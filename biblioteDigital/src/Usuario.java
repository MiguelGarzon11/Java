import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private ArrayList<Libro> librosPrestados;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.librosPrestados = new ArrayList<>();
    }

    public String getNombre() { return nombre; }

    public void prestarLibro(Libro libro) {
        libro.prestar();
        librosPrestados.add(libro);
    }

    public void mostrarLibrosPrestados() {
        System.out.println("Libros prestados por " + nombre + ":");
        for (Libro libro : librosPrestados) {
            System.out.println("   - " + libro.getTitulo());
        }
    }
}
