package Homework_17112026;


public class Main {

    public static void main(String[] args) {
        System.out.println("NOMINA");
        Employee v1 = new Salesman("Carlos Pérez", 1200.0, 5000.0, 0.05); // Sueldo + 5% de 5000 en ventas
        Employee g1 = new Manager("Ana Gómez", 3500.0, 1000.0);          // Sueldo + 1000 de bono

        System.out.println("--- Sueldos Iniciales (Polimorfismo) ---");
        v1.showInfo();
        g1.showInfo();

        // Vean que cada uno calcula distinto a pesar de llamar al mismo método calcularSueldo()
        System.out.println("\n--- Probando sobrecarga de aumentarSueldo() ---");
        
        // Aumentando al Vendedor usando la versión de monto fijo ($200)
        v1.raiseSalary(200.0);
        System.out.println("Tras aumentar $200.0 al sueldo base de Carlos:");
        v1.showInfo();

        // Aumentando a la Gerente usando la versión de porcentaje (10% de aumento)
        g1.raiseSalary(10.0, true);
        System.out.println("Tras aplicar un 10% de aumento al sueldo base de Ana:");
        g1.showInfo();

    }
    
    
}
