import utilities.*;

public class Ejercicio2Evaluador{
    public static void main(String[] args){
        String[] estudiantes = {"Ana", "Luis", "Sofia", "Carlos",
        "Valentina", "Mateo"};
        String[] evaluaciones = {"Quiz 1", "Quiz 2", "Taller", "Proyecto"};
        double[][] notas = {
        {4.5, 4.9, 3.8, 4.2}, // Ana
        {3.5, 4.0, 4.9, 4.0}, // Luis
        {2.5, 3.0, 2.8, 2.6}, // Sofia
        {3.0, 2.5, 3.2, 3.4}, // Carlos
        {5.0, 4.8, 4.6, 4.9}, // Valentina
        {2.0, 2.5, 1.8, 2.2} // Mateo
        };
        double[] pesos = {0.20, 0.20, 0.25, 0.35}; // suman 1.0
        double[] asistencia = {0.95, 0.70, 0.88, 0.80, 1.00, 0.76}; // 0.95 = 95%
// Tu código aquí

        int cantidadEstudiantes = estudiantes.length;
        double[] promediosEstudiantes = new double[cantidadEstudiantes];
        State[] estadosEstudiantes = new State[cantidadEstudiantes];

        

        System.out.println("===== RESULTADOS DEL CURSO ======");
        System.out.printf("%-10s  %8s %11s %s\n" , "Estudiantes", 
            "Promedio" , "Asistencia", "Estado");
        // se evalue el promedio ponderado de cada fila y su estado para determinar si pasa o no
            for (int i = 0; i < cantidadEstudiantes; i++){
            promediosEstudiantes[i] = EvaluatorCalculator.promedioPonderado(notas[i], pesos);
            estadosEstudiantes[i] = EvaluatorCalculator.evaluar(promediosEstudiantes[i],asistencia[i] );
            System.out.printf("%10s %8.2f %10.0f%% %s\n", estudiantes[i], promediosEstudiantes[i], asistencia[i] * 100, estadosEstudiantes[i]);

        }
        // invoca funcion para determianr la cantidad de estudiantes que pasaron
        int[] conteoEstados = EvaluatorCalculator.contarEstados(estadosEstudiantes);

        int aprobados = conteoEstados[0];
        int recuperacion = conteoEstados[1];
        int reprobados = conteoEstados[2];

        
        System.out.printf("Aprobados: %d | Recuperacion: %d | Reprobados: %d\n\n", aprobados, recuperacion, reprobados);
        System.out.println("===== ANALISIS POR EVALUACION =====");
        //invoca la funcion para evaluar los cursos y sus promedios
        EvaluatorCalculator.analizarEvaluaciones(notas, evaluaciones, estudiantes);

        int[] orden = new int[cantidadEstudiantes];
        for (int i = 0; i < cantidadEstudiantes; i++) {
            orden[i] = i;
        }
        //se utiliza el metodo burbuja para ordenar los estudiantes de mayor a menor
        for (int i = 0; i <= orden.length - 2; i++) {
            for (int j = 0; j <= orden.length - 2 - i; j++) {
                if (promediosEstudiantes[orden[j]] < promediosEstudiantes[orden[j + 1]]) {
                    int temp = orden[j];
                    orden[j] = orden[j + 1];
                    orden[j + 1] = temp;
                }
            }
        }

        System.out.println("===== RANKING =====");
        for (int p = 0; p < cantidadEstudiantes; p++) {
            int idx = orden[p];
            System.out.printf("%d. %-10s %.2f\n", (p + 1), estudiantes[idx], promediosEstudiantes[idx]);
        }

}

}