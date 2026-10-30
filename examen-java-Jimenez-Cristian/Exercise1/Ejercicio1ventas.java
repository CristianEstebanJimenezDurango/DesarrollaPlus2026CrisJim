import utilities.*;

public class Ejercicio1ventas {

    public static final double META_SEMANAL = 1000.0;

    public static void main(String[] args) {
        
        String[] dias = {
            "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"
        };
        double[] ventas = {
            1250.5, 980.0, 1430.75, 760.25, 2100.0, 2650.5,1890.0
        };

    // se iniician variables que van a ser utilizadas en el codigo   
    int diaEncimaPromedio = 0;
    int longitudDias = dias.length;

    // se calcula la suma y promedio

    double calcularTotal = Calculator.calcularTotal(ventas);
    double promedio = Calculator.calcularPromedio(ventas);
    
    System.out.println("=== REPORTE DE VENTAS SEMANAL ===");
    System.out.printf("%-10s %10s   %s\n", "Día", "Venta", "Nivel");

    // se clasidica con un for, se imprime y se confirma si las ventas de este dia especifico superan el promedio

    for (int i = 0; i< longitudDias; i++){
        String nivel = Calculator.clasificar(ventas[i], promedio);
        System.out.printf("%-10s %10s   %s\n", dias[i], ventas[i],nivel);
        if (ventas[i] > promedio) {
            diaEncimaPromedio++;
        }
    }

    // se imprimen todos los datos y se usa un oneliner para mejor dia y peor dia
    System.out.println("=======================================");
    System.out.println("Total Semanal: " + calcularTotal);
    System.out.printf("Promedio diario: %.2f\n", promedio);
    System.out.printf("Mejor dia: %s (%.2f)\n", dias[Calculator.indiceMayor(ventas)] ,ventas[Calculator.indiceMayor(ventas)]);
    System.out.printf("Peor dia: %s (%.2f)\n", dias[Calculator.indiceMenor(ventas)] ,ventas[Calculator.indiceMenor(ventas)]);
    System.out.println("Dias por encima del promedio: " + diaEncimaPromedio);


    // se evalua si la suma total es mayor a la meta asignada por la empresa
    if (calcularTotal >= META_SEMANAL) {
        double success = calcularTotal - META_SEMANAL;
        System.out.printf("Meta cumplida. Superaste la meta por %.2f\n", success);
    }else {
        double missing = META_SEMANAL - calcularTotal;
        System.out.printf("Faltaron %.2f\n", missing);
    }

    
    }
    
}
