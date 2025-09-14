public class App {
    public static void main(String[] args) {
        Usuario u1 = new Usuario("Miguel");
        Usuario u2 = new Usuario("Camila");

        LibroFisico fisico = new LibroFisico("Cien años de soledad", "García Márquez", "12345", "Estante A3");
        LibroDigital digital = new LibroDigital("El Quijote", "Cervantes", "67890", "http://biblioteca.com/quijote");

        u1.prestarLibro(fisico);  
        u1.prestarLibro(digital);  
        u2.prestarLibro(fisico);
        u2.prestarLibro(digital);

        System.out.println();
        u1.mostrarLibrosPrestados();
    }
}
