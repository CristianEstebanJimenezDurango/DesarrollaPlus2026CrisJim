import java.util.Scanner;

public class exercise2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. Crear el vector de tamaño 3
        double[] notas = new double[3];
        double suma = 0;
        int intentos = 0;

        System.out.println("--- Ronda 1: Promedio con Vector ---");

        // 2. Llenar el vector pidiendo cada nota con un for
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Ingrese la nota " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble(); // Primero leemos la nota

            // Evaluamos si la nota es inválida
            if (notas[i] < 0 || notas[i] > 5) {
                intentos++;
                System.out.println("Nota inválida. Debe estar entre 0 y 5. Te quedan " + (3 - intentos) + " intentos.");
                
                if (intentos >= 3) {
                    System.out.println("Has excedido el número de intentos. Saliendo del programa.");
                    scanner.close();
                    return; 
                }
                
                // Decrementar i para repetir la entrada de la nota actual 
                // (el incremento automático del 'for' compensará este decremento)
                i--; 
            } else {
                // Si la nota es válida, reiniciamos los intentos para la siguiente nota
                intentos = 0; 
            }
        }

        // 3. Sumar todo en una variable con otro for
        for (int j = 0; j < notas.length; j++) {
            suma += notas[j];
        }

        // 4. Dividir la suma entre notas.length y mostrar el resultado
        double promedio = suma / notas.length;
        System.out.printf("El promedio es: %.2f\n", promedio);

        scanner.close();
    }
}