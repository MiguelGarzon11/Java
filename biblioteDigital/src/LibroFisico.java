public class LibroFisico extends Libro {
    private String ubicacion;

    public LibroFisico(String titulo, String autor, String isbn, String ubicacion) {
        super(titulo, autor, isbn);
        this.ubicacion = ubicacion;
    }

    @Override
    public void prestar(Usuario usuario) {
        if (isDisponible()) {
            setDisponible(false);
            usuario.agregarLibro(this);
            System.out.println("Libro físico prestado a " + usuario.getNombre());
        } else {
            System.out.println("Este libro físico no está disponible.");
        }
    }
}
