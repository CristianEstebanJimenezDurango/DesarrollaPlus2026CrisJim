public class exercise2 {
    public static void main(String[] args) {
        
        int [] numbers = {10, 20, 30, 40, 50};
        int index = 5; 
        try {
            System.out.println("Accessing index " + index + ": " + numbers[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index " + index + " is out of bounds for the array.");
        }
    }
}
