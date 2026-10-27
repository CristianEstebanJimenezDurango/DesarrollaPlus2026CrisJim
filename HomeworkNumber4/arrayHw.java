package HomeworkNumber4;

public class arrayHw {
    public static void main(String[] args) {
        
        int[] ejemplo1 = {1, 2, 3, 6, 9};
        int[] ejemplo2 = {2, 3, 6};
        System.out.println(countEvenOdd(ejemplo1));
        System.out.println(countEvenOdd(ejemplo2));
    }

    public static String countEvenOdd(int[] numbers) {
        int evenCount = 0;
        int oddCount = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        String partePares = (evenCount == 1) ? "1 par" : evenCount + " pares";
        String parteImpares = (oddCount == 1) ? "1 impar" : oddCount + " impares";
        return partePares + ", " + parteImpares;
    }
    
}
