import java.util.Scanner;

// 1. Excepción personalizada
class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}

public class MiniCajero {
    private static double saldo = 1000.0; 

    public static void retirar(double monto) throws SaldoInsuficienteException {
        if (monto <= 0) {
            throw new SaldoInsuficienteException("El monto a retirar debe ser mayor a cero.");
        }
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Fondos insuficientes. Intentaste retirar " + monto + ", pero tu saldo actual es " + saldo);
        }
        saldo -= monto;
        System.out.println("✅ Retiro exitoso. Nuevo saldo: " + saldo);
    }

    // Método para depositar dinero
    public static void depositar(double monto) throws SaldoInsuficienteException {
        if (monto <= 0) {
            throw new SaldoInsuficienteException("El monto a depositar debe ser mayor a cero.");
        }
        saldo += monto;
        System.out.println("✅ Depósito exitoso. Nuevo saldo: " + saldo);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("=== BIENVENIDO AL MINI-CAJERO ===");

        while (continuar) {
            System.out.println("\nSaldo actual: " + saldo);
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = 0;
            
            // Validación de la opción del menú con try/catch para evitar crasheos
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Debe ingresar un número entero válido para la opción.");
                continue; // Vuelve al inicio del bucle
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el monto a depositar: ");
                    try {
                        double montoDeposito = Double.parseDouble(scanner.nextLine());
                        depositar(montoDeposito);
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Error: Ingrese un valor numérico válido.");
                    } catch (SaldoInsuficienteException e) {
                        System.out.println("⚠️ " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el monto a retirar: ");
                    try {
                        double montoRetiro = Double.parseDouble(scanner.nextLine());
                        retirar(montoRetiro);
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Error: Ingrese un valor numérico válido.");
                    } catch (SaldoInsuficienteException e) {
                        System.out.println("⚠️ " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("¡Gracias por usar el mini-cajero! Saliendo...");
                    continuar = false;
                    break;

                default:
                    System.out.println("❌ Opción inválida. Seleccione entre 1 y 3.");
                    break;
            }
        }

        scanner.close();
    }
}