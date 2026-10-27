import java.util.Scanner;

public class exercise1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digita un número: ");
        int number = scanner.nextInt();

        int multipleByFive = 0;
        int i = 1;

        while (i <= number) {

            if (i % 5 == 0) {
                System.out.println("El número es : " + i + "*");
                multipleByFive++;
            } else {
                System.out.println("El número es : " + i);
            }
            i++;

        }

        System.out.println("El número de múltiplos de 5 es: " + multipleByFive);

        scanner.close();
    }
    
}
