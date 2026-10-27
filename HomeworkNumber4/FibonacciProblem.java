public class FibonacciProblem {
    public static void main(String[] args) {
        System.out.println("--- Pruebas de la Secuencia de Fibonacci ---");
        
        // Ejemplos dados en el problema
        System.out.println("Entrada: 4  --  Salida: \"" + fibonacci(4) + "\"");
        System.out.println("Entrada: 0  --  Salida: \"" + fibonacci(0) + "\"");
        System.out.println("Entrada: 8  --  Salida: \"" + fibonacci(8) + "\"");
        
    }

    public static String fibonacci(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        int a = 0, b = 1;
        for (int i = 1; i <= n; i++) {
            result.append(a);
            if (i < n) {
                result.append(", ");
            }
            int next = a + b;
            a = b;
            b = next;
        }
        return result.toString();
    
    }
}
