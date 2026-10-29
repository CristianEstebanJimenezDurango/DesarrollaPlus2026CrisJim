 import java.util.Scanner;

 public class exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String variable = scanner.nextLine();

        try {
            int number = Integer.parseInt(variable);
            System.out.println("Result: " + 100 / number);
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid integer." + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed." + e.getMessage());
        }
        scanner.close();
    }
}
