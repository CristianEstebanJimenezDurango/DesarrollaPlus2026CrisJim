public class pass {
    public static void main(String[] args) {
        // Matriz de notas (estudiantes en filas, materias en columnas)
        double[][] notas = {
            {7, 8, 6},
            {9, 5, 7},
            {6, 6, 9}
        };

        int estudiantesAprobadosTotal = 0;

        for (int estudiantes = 0; estudiantes < notas.length; estudiantes++) {
            boolean aproboTodas = true; 

            for (int materias = 0; materias < notas[estudiantes].length; materias++) {
                if (notas[estudiantes][materias] < 6.0) {
                    aproboTodas = false;
                    break; 
                }
            }

            if (aproboTodas) {
                estudiantesAprobadosTotal++;
                System.out.println("El estudiante " + (estudiantes + 1) + " aprobó TODAS sus materias");
            } else {
                System.out.println("El estudiante " + (estudiantes + 1) + " reprobó alguna materia");
            }
        }

        System.out.println("\nTotal de estudiantes que aprobaron todas sus materias: " + estudiantesAprobadosTotal);
    }
}
