public class LibroDigital extends Libro {
    private String enlaceDescarga;

    public LibroDigital(String titulo, String autor, String ISBN, String enlaceDescarga) {
        super(titulo, autor, ISBN);
        this.enlaceDescarga = enlaceDescarga;
    }

    @Override
    public void prestar() {
        System.out.println("Libro digital '" + getTitulo() + "' disponible en:");
        System.out.println(enlaceDescarga);
    }
}
