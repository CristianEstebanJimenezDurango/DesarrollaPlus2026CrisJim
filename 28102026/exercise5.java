import java.util.Scanner;

public class exercise5 {

    private static double saldo = 1000.0; 

    public static void retirar(double monto) throws SaldoInsuficienteException {
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Error: El monto a retirar (" + monto + ") supera el saldo actual (" + saldo + ").");
        }
        saldo -= monto;
        System.out.println("Retiro exitoso. Nuevo saldo: " + saldo);
    }

    public static void main(String[] args) {

        System.out.println("--- Prueba de Excepción Personalizada ---");
        System.out.println("Saldo disponible: " + saldo);
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese el monto a retirar: ");
            double montoARetirar = scanner.nextDouble();
            System.out.println("Intentando retirar: " + montoARetirar);
            retirar(montoARetirar);
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        } finally {
            System.out.println("Operación finalizada.");
        }
    
    scanner.close();
    }
    
}

class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}


