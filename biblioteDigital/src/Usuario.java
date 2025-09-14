import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private ArrayList<Libro> librosPrestados = new ArrayList<>();

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarLibro(Libro libro) {
        librosPrestados.add(libro);
    }

    public void mostrarLibrosPrestados() {
        if (librosPrestados.isEmpty()) {
            System.out.println(nombre + " no tiene libros prestados.");
        } else {
            System.out.println("Libros prestados a " + nombre + ":");
            for (Libro libro : librosPrestados) {
                System.out.println(" - " + libro.getTitulo());
            }
        }
    }
}
