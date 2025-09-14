import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Libro> libros = new ArrayList<>();

        while (true) {
            System.out.println("\n=== Bienvenido a la Biblioteca Digital ===");
            System.out.println("1. Crear usuario");
            System.out.println("2. Crear libro físico");
            System.out.println("3. Crear libro digital");
            System.out.println("4. Prestar libro");
            System.out.println("5. Mostrar libros prestados");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese su nombre: ");
                    String nombre = sc.nextLine();
                    usuarios.add(new Usuario(nombre));
                    System.out.println("Usuario creado.");
                    break;

                case 2:
                    System.out.print("Título: ");
                    String tituloF = sc.nextLine();
                    System.out.print("Autor: ");
                    String autorF = sc.nextLine();
                    System.out.print("ISBN: ");
                    String isbnF = sc.nextLine();
                    System.out.print("Ubicación: ");
                    String ubicacion = sc.nextLine();
                    libros.add(new LibroFisico(tituloF, autorF, isbnF, ubicacion));
                    System.out.println("Libro físico creado.");
                    break;

                case 3:
                    System.out.print("Título: ");
                    String tituloD = sc.nextLine();
                    System.out.print("Autor: ");
                    String autorD = sc.nextLine();
                    System.out.print("ISBN: ");
                    String isbnD = sc.nextLine();
                    System.out.print("Enlace descarga: ");
                    String enlace = sc.nextLine();
                    libros.add(new LibroDigital(tituloD, autorD, isbnD, enlace));
                    System.out.println("Libro digital creado.");
                    break;

                case 4:
                    if (usuarios.isEmpty() || libros.isEmpty()) {
                        System.out.println("Debe haber al menos un usuario y un libro.");
                        break;
                    }
                    System.out.println("Usuarios:");
                    for (int i = 0; i < usuarios.size(); i++) {
                        System.out.println((i + 1) + ". " + usuarios.get(i).getNombre());
                    }
                    System.out.print("Seleccione usuario: ");
                    int uIndex = sc.nextInt() - 1;
                    sc.nextLine();

                    System.out.println("Libros disponibles:");
                    for (int i = 0; i < libros.size(); i++) {
                        if (libros.get(i).isDisponible()) {
                            System.out.println((i + 1) + ". " + libros.get(i).getTitulo());
                        }
                    }
                    System.out.print("Seleccione libro: ");
                    int lIndex = sc.nextInt() - 1;
                    sc.nextLine();

                    libros.get(lIndex).prestar(usuarios.get(uIndex));
                    break;

                case 5:
                    for (Usuario u : usuarios) {
                        u.mostrarLibrosPrestados();
                    }
                    break;

                case 6:
                    System.out.println("¡Gracias por usar la biblioteca!");
                    sc.close();
                    return;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
