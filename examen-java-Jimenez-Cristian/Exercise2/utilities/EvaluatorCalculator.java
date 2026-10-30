package utilities;

public class EvaluatorCalculator {
    
    public static double promedioPonderado(double[] notasEstudiante, double[] pesosNotas) {

        double suma = 0; 
        for ( int i = 0; i< notasEstudiante.length; i++) {
            suma += notasEstudiante[i] * pesosNotas[i];
        }
        return suma;
    }

    public static State evaluar(double promedio, double asistencia) {

        if (asistencia < 0.75) {
            return State.REPROBADO;
        }else if (promedio >= 3.0) {
            return State.APROBADO;
        }else if( promedio >= 2.5) {
            return State.RECUPERACION;
        }else{
            return State.REPROBADO;
        }
    }

    public static int[] contarEstados(State[] estadosEstudiantes) {
        int aprobados = 0;
        int recuperacion = 0;
        int reprobados = 0;

        for (int i = 0; i < estadosEstudiantes.length; i++) {
            if (estadosEstudiantes[i] != null) {
                switch (estadosEstudiantes[i]) {
                    case APROBADO:
                        aprobados++;
                        break;
                    case RECUPERACION:
                        recuperacion++;
                        break;
                    case REPROBADO:
                        reprobados++;
                        break;
                }           
            }
        }
        
        return new int[] { aprobados, recuperacion, reprobados };
    }

    public static void analizarEvaluaciones(double[][] notas, String[] evaluaciones, String[] estudiantes) {
        int cantidadEstudiantes = estudiantes.length;
        int cantidadCursos = evaluaciones.length;
        for (int j = 0; j < cantidadCursos; j++) {
            double sumaCursos = 0;
            int indexMejorEstudiante = 0;
            double indiceMayorNota = notas[0][j];

            for (int i = 0; i < cantidadEstudiantes; i++) {
                sumaCursos += notas[i][j];
                if (notas[i][j] > indiceMayorNota) {
                    indiceMayorNota = notas[i][j];
                    indexMejorEstudiante = i;
                }
            }
            double promedioCursos = sumaCursos / cantidadEstudiantes;
            System.out.printf("%-10s promedio %.2f | mejor: %s (%.1f)\n", evaluaciones[j], promedioCursos, estudiantes[indexMejorEstudiante], indiceMayorNota);
        }
    }

}
