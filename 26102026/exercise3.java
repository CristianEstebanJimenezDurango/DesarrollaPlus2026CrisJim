public class exercise3 {
    public static void main(String[] args) {
    
     
    double [][] notas = 
    {
            {7, 8, 6},
            {9, 5, 7},
            {6, 6, 9}
        };

    double[] pesos = {0.2,0.3,0.5}; // Pesos para cada nota

    System.out.println("--- Ronda 2: Promedio ponderado ---");

    for (int filas = 0; filas < notas.length; filas++) {
        double sumaPonderada = 0;
        for (int columnas = 0; columnas < notas[filas].length; columnas++) {
            sumaPonderada += notas[filas][columnas] * pesos[columnas];
        }
        System.out.printf("El promedio ponderado del estudiante %d es: %.2f\n", filas + 1, sumaPonderada);
        if (sumaPonderada >= 6) {
            System.out.println("El estudiante " + (filas + 1) + " ha aprobado.");
        } else {
            System.out.println("El estudiante " + (filas + 1) + " ha reprobado.");
        }
    }

}
    
}
