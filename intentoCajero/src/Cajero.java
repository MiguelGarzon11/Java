import java.util.Scanner;

public class Cajero {
    public static void main(String[] args) {
        final String PIN_CORRECTO = "1234";
        Scanner sc = new Scanner(System.in);

        int intentos = 0;
        boolean aprobado = false;

        while (intentos < 3) {
            System.out.print("Ingrese su PIN de 4 dígitos: ");
            String pinIngresado = sc.nextLine();

            if (pinIngresado.length() == 4 && pinIngresado.matches("\\d+")) {
                if (pinIngresado.equals(PIN_CORRECTO)) {
                    System.out.println("Transacción aprobada.");
                    aprobado = true;
                    break;
                } else 
                    System.out.println("PIN incorrecto.");
                }
            else {
                System.out.println("El PIN debe tener exactamente 4 dígitos numéricos.");
            }
            intentos++;
        }

        if (!aprobado) {
            System.out.println("Tarjeta bloqueada, contacte con el banco.");
        }
        sc.close();
    }
}
