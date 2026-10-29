public class exercise3 {
    public static void main(String[] args) {
        try {
            int n = Integer.parseInt("abc");
            System.out.println("Parsed number: " + n);
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid integer." + e.getMessage());
        }
    }
}
