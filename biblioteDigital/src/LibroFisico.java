public class LibroFisico extends Libro {
    private String ubicacion;

    public LibroFisico(String titulo, String autor, String ISBN, String ubicacion) {
        super(titulo, autor, ISBN);
        this.ubicacion = ubicacion;
    }

    @Override
    public void prestar() {
        if (isDisponible()) {
            setDisponible(false);
            System.out.println("Libro físico '" + getTitulo() + "' prestado.");
            System.out.println("Ubicación: " + ubicacion);
        } else {
            System.out.println("Libro físico no disponible.");
        }
    }
}
