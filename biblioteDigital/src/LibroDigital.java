public class LibroDigital extends Libro {
    private String enlaceDescarga;

    public LibroDigital(String titulo, String autor, String isbn, String enlaceDescarga) {
        super(titulo, autor, isbn);
        this.enlaceDescarga = enlaceDescarga;
    }

    @Override
    public void prestar(Usuario usuario) {
        if (isDisponible()) {
            setDisponible(false);
            usuario.agregarLibro(this);
            System.out.println("Libro digital prestado a " + usuario.getNombre() +
                    ". Enlace: " + enlaceDescarga);
        } else {
            System.out.println("Este libro digital no está disponible.");
        }
    }
}
