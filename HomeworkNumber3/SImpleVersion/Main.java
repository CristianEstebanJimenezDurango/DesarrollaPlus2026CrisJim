package HomeworkNumber3.SImpleVersion;

import HomeworkNumber3.SImpleVersion.utilities.Calculator;
import HomeworkNumber3.SImpleVersion.utilities.Entry;
import HomeworkNumber3.SImpleVersion.utilities.OutputCode;
import HomeworkNumber3.SImpleVersion.utilities.State;

public class Main {

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            OutputCode.printMenu();
            int option = Entry.readOption();

            switch (option) {
                case 1:
                    int gradesCount = Entry.readInt("Ingrese la cantidad de notas: ");
                    int[] grades = new int[gradesCount];
                    for (int i = 0; i < grades.length; i++) {
                        grades[i] = Entry.readInt("Ingrese la nota " + (i + 1) + ": ");
                    }
                    double average = Calculator.calculateAverage(grades);
                    int totalAssistance = Entry.readInt("Ingrese el total de asistencias: ");
                    int totalClasses = Entry.readInt("Ingrese el total de clases: ");
                    double assistancePercentage = Calculator.AssistancePercentage(totalAssistance, totalClasses);
                    State state = Calculator.evaluateState(average, assistancePercentage);
                    OutputCode.printResult(state, average, assistancePercentage);
                    break;
                case 2:
                    OutputCode.printExitMessage("Saliendo del programa...");
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }
    
}
