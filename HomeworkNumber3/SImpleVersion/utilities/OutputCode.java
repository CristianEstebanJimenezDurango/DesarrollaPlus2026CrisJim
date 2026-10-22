package HomeworkNumber3.SImpleVersion.utilities;


public class OutputCode {
    
    public static void printMenu() {
        System.out.println("Menu:");
        System.out.println("1. Calcular promedio:");
        System.out.println("2. Salir");
    }

    public static void printResult(State state, double average, double assistancePercentage) {
        
        String emoji = (state == State.APROBADO) ? "✅" : "❌";

        switch (state) {
            case APROBADO:
                System.out.println("¡Felicidades! Has aprobado el curso. " + emoji);
                break;
            case RECHAZADO:
                System.out.println("Lo siento, no has aprobado el curso. " + emoji);
                break;
            case RECHAZADO_ASISTENCIA:
                System.out.println("Lo siento, no has aprobado el curso por baja asistencia. " + emoji);
                break;
        }
        
        System.out.println("Resultado:");
        System.out.println("Estado: " + state + " " + emoji);
        System.out.printf("Promedio: %.2f\n", average);
        System.out.printf("Porcentaje de asistencia: %.2f%%\n", assistancePercentage);
    }
    

    public static void printExitMessage(String message) {
        System.out.println(message);
    }
}