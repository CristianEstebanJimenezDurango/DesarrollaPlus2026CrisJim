package HomeworkNumber3.SImpleVersion.utilities;

public class Calculator {
    
    public static double calculateAverage(double[] numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum / numbers.length;
    }

    public static double AssistancePercentage(double totalAssistance, double totalClasses) {
        return (totalAssistance / totalClasses) * 100;
    }

    
    public static State evaluateState(double average, double assistancePercentage) {
        if (average >= 4.5 && assistancePercentage >= 80) {
            return State.APROBADO;
        } else if (average < 3 && assistancePercentage >= 80) {
            return State.RECHAZADO;
        } else if (average >= 3 && assistancePercentage < 80) {
            return State.RECHAZADO_ASISTENCIA;
        } else {
            return State.RECHAZADO;
        }
    }
}
