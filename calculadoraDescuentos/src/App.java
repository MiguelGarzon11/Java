import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> discountValues = new ArrayList<>();
        discountValues.add(10);
        discountValues.add(25);
        discountValues.add(50);

        while (true) {
            System.out.print("=== ¡ Bienvenido de nuevo ! ===\n");

            System.out.print("Ingresa el valor del producto: \n");
            double product = sc.nextDouble();

            System.out.print("Ingresa el valor de descuento: \n");
            System.out.print("¡ Recuerda solo se permiten 3 valores de descuento !\n");
            int vDiscount = sc.nextInt();

            if (discountValues.contains(vDiscount)) {
                // Usamos DiscountCalculator y DiscountResult
                DiscountResult result = DiscountCalculator.valueDiscount(product, vDiscount);
                
                System.out.println("El nuevo valor del producto es: " + result.getNewValue());
                System.out.println("El descuento aplicado fue: " + result.getDeduction());
            } else {
                System.out.println("Ese valor de descuento no es válido. Valores validos: 10 % 25 % 50 % ");
            }
        }
    }
}
