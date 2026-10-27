import java.util.Random;
import java.util.Scanner;       


public class exercise3 {

        public static void main(String [] args) {

        Scanner scanner = new Scanner(System.in);
        int secretNumber = (int) (Math.random() * 100 + 1);

        int userGuess;
        int tries = 0;
        int difference;
        
        do {
            System.out.print("Adivina el número secreto (entre 1 y 100): ");
            userGuess = scanner.nextInt();
            tries++;
            difference = Math.abs(userGuess - secretNumber);

            if (difference == 0) {
                System.out.println("¡Felicidades! Adivinaste el número secreto.");
            } else if (difference > 20) {
                System.out.println("Muy lejos");
            } else if (difference <= 10) {
                System.out.println("Caliente");
            } else {
                System.out.println(userGuess < secretNumber ? "Mas alto" : "Mas bajo");
            }

        } while (userGuess != secretNumber);

        if (tries <= 3) 
        {   System.out.println("Eres un genio! Adivinaste el número secreto en " + tries + " intentos.");
            System.out.println("El número secreto era: " + secretNumber);
        } else  if (tries <= 7){
            System.out.println("Bien hecho, Adivinaste el número secreto en " + tries + " intentos.");
            System.out.println("El número secreto era: " + secretNumber);
        }else{
            System.out.println("Por fin lo lograste! Adivinaste el número secreto en " + tries + " intentos.");
            System.out.println("El número secreto era: " + secretNumber);
        }

        scanner.close();
}
    
}
