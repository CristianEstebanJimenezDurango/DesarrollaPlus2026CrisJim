import java.util.Scanner;
import java.util.Random;

public class exercise2 {
    public static void main(String [] args) {

        Scanner scanner = new Scanner(System.in);
        Random randomNumber = new Random();
        int secretNumber = randomNumber.nextInt(100) + 1;

        int userGuess;
        int tries = 0;
        
        do {
            System.out.print("Adivina el número secreto (entre 1 y 100): ");
            userGuess = scanner.nextInt();
            tries++;

            if (userGuess < secretNumber) {
                System.out.println("El numero secreto es mas grande. Intenta de nuevo.");
            } else if (userGuess > secretNumber) {
                System.out.println("El numero secreto es mas pequeño. Intenta de nuevo.");
            } else {
                System.out.println("¡Felicidades! Adivinaste el número secreto en " + tries + " intentos.");
                System.out.println("El número secreto era: " + secretNumber);
            }
        } while (userGuess != secretNumber);

        scanner.close();
}
    }
