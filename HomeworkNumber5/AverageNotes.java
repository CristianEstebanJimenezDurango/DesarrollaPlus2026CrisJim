public class AverageNotes {
    public static void main(String[] args) {
        // Matriz de notas (estudiantes en filas, materias en columnas)
        double[][] notas = {
            {7, 8, 6},
            {9, 5, 7},
            {6, 6, 9}
        };

        System.out.println("--- Reto 1: Promedio por Materia ---");

        // El for de afuera recorre columnas (materias); el de adentro, filas (estudiantes)
        for (int materias = 0; materias < notas[0].length; materias++) {
            double suma = 0;

            for (int estudiantes = 0; estudiantes < notas.length; estudiantes++) {
                suma += notas[estudiantes][materias]; 
             }

            double promedio = suma / notas.length;

            System.out.printf("Materia %d --> Promedio: %.2f\n", (materias + 1), promedio);
        }
    }
}