
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el primer número que quiera sumar:");
        int numero1 = sc.nextInt();
        
        System.out.println("Ingrese el segundo número que quiera sumar:");
        int numero2 = sc.nextInt();

        int suma = numero1 + numero2;

        System.out.println("La suma de " + numero1 + " + " + numero2 + " es: " + suma);


        sc.close();
    }
}
