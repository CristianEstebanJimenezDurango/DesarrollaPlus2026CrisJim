import java.util.Scanner;

public class exercise4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int failedAttempts = 0;
        final int MAX_ATTEMPTS = 3;
        boolean success = false;
        int number = 0;

        while (failedAttempts < MAX_ATTEMPTS && !success) {
            System.out.print("Ingrese un número entero: ");
            String input = scanner.nextLine();

            try {
                number = Integer.parseInt(input);
                success = true;
            } catch (NumberFormatException e) {
                int remainingAttempts = MAX_ATTEMPTS - failedAttempts - 1;
                if (remainingAttempts > 0) {
                    System.out.println("Error: Por favor, ingrese un número entero válido. Le quedan " + remainingAttempts + " intentos.");
                } else {
                    System.out.println("Error: Por favor, ingrese un número entero válido. No tiene más intentos.");
                }
                failedAttempts++;
                System.out.println("Error: Por favor, ingrese un número entero válido. Intento " + failedAttempts + " de " + MAX_ATTEMPTS);
            }
        }

        if (success) {
            System.out.println("Ingresó: " + number);
        } else {
            System.out.println("Se alcanzó el número máximo de intentos. Saliendo del programa.");
        }

        scanner.close();

    }
}
