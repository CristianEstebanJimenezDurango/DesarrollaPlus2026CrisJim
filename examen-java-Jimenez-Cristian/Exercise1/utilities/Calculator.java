package utilities;

public class Calculator {


    // se usa un for each para calcular el total ya qeu solo se necesita sumar cada uno de los valores

    public static double calcularTotal(double[] ventas) {
        double total = 0.0;
        for (double venta : ventas) {
            total += venta;
        }
        return total;
    }

    // se cuida que no ocurra una division por cero, de otra forma solo es una division por la suma total
    public static double calcularPromedio(double[] ventas) {
        if (ventas.length == 0) {
            return 0.0;
        }
        double total = calcularTotal(ventas);
        return total / ventas.length;
    }

    // Dado que el for iterara en cada uno de los valores solo tiene como valores de entrada una variable por iteraccion

    public static String clasificar (double venta, double promedio) {

        if (venta >= promedio *1.2) {
            return "ALTA";
        }else if (venta < promedio *0.8) {
            return "BAJA";
        }else {
            return "NORMAL";
        }
    }

    // se empieza en el indez 1 para comparar con el anterior y asi sucesivamente
    public static int indiceMayor(double[] ventas) {
        int index = 0;
        for (int i = 1; i<ventas.length; i++) {
            if (ventas[i] > ventas[index]) {
                index = i;
            }
            
        }
        return index;
    }

    // el algortimo solo cambia en comparar que sea menor 
    public static int indiceMenor(double[] ventas) {
        int index = 0;
        for (int i = 1; i<ventas.length; i++) {
            if (ventas[i] < ventas[index]) {
                index = i;
            }
         }
            return index;

    }
}

    

