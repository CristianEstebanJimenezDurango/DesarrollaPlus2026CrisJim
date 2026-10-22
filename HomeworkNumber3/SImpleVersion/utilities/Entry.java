package HomeworkNumber3.SImpleVersion.utilities;
import java.util.Scanner;

public class Entry {

    private static Scanner scanner = new Scanner(System.in);

    public static int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada invalida. Por favor, ingrese un número entero:");
            scanner.next(); // Clear the invalid input
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }

    public static double readDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada invalida. Por favor, ingrese un número:");
            scanner.next(); // Clear the invalid input
            System.out.print(prompt);
        }
        return scanner.nextDouble();
    }

    public static int readOption() {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada invalida. Por favor, ingrese un número entero:");
            scanner.next(); // Clear the invalid input
            System.out.print("Enter your option: ");
        }
        return scanner.nextInt();
    }

    
}
