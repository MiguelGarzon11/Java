
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        while (true) {

            try {
                System.out.println("Ingrese su temperatura corporal:\n");
                String entrada = sc.nextLine().replace((","), ("."));
                double temp = Double.parseDouble(entrada);

                String categoria = "";

                if (temp < 36.1) {
                    categoria = "hipotermia";
                } else if (temp <= 37.5) {
                    categoria = "normal";
                } else if (temp <= 38.4) {
                    categoria = "Febricula";
                } else if (temp <= 39.4) {
                    categoria = "Fiebre moderada";
                } else if (temp >= 39.5) {
                    categoria = "Fiebre alta";
                }

                switch (categoria) {
                    case "hipotermia":
                        System.out.println("Temperatura baja: Hipotermia");
                        break;
                    case "normal": 
                        System.out.println("Temperatura normal.");
                        break;
                    case "Febricula":
                        System.out.println("Temperatura un poco arriba de lo normal: Febricula");
                        break;
                    case "Fiebre moderada":
                        System.out.println("Fiebre moderada.");
                        break;
                    case "Fiebre alta": 
                        System.out.println("Usted tiene fiebre alta.");
                        break;
                    default:
                    System.out.println("Valor no reconocido.");
                    break;

                }
            } catch (InputMismatchException e ) {
                System.out.println("Error: no ingreso un número decimal válido.");
            }
        }
    }
}
