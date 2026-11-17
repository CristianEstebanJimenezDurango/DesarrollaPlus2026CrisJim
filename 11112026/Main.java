class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, String titular) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = 0.0;
    }

    public boolean depositar(double monto) {
        if (monto <= 0) {
            return false;
        }

        saldo += monto;
        return true;
    }

    public boolean retirar(double monto) {
        if (monto <= 0 || monto > saldo) {
            return false;
        }

        saldo -= monto;
        return true;
    }

    public boolean transferir(CuentaBancaria destino, double monto) {
        if (destino == null || monto <= 0 || this == destino) {
            return false;
        }

        if (!this.retirar(monto)) {
            return false;
        }

        if (!destino.depositar(monto)) {
            this.depositar(monto);
            return false;
        }

        return true;
    }

    public void mostrarInfo() {
        System.out.println("Cuenta: " + numeroCuenta + " | Titular: " + titular + " | Saldo: $" + String.format("%.2f", saldo));
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== PRUEBAS DE CUENTA BANCARIA CON ENCAPSULAMIENTO FUERTE ===\n");

        // Creación de dos cuentas (inician en $0.00)
        CuentaBancaria cuenta1 = new CuentaBancaria("CTA-001", "Cristian Jiménez");
        CuentaBancaria cuenta2 = new CuentaBancaria("CTA-002", "Víctor Jiménez");

        System.out.println("--- Estado Inicial ---");
        cuenta1.mostrarInfo();
        cuenta2.mostrarInfo();

        // 1. Probar Depósitos
        System.out.println("\n--- Probando Depósitos ---");
        System.out.println("Depositando $500.0 en CTA-001: " + cuenta1.depositar(500.0));
        System.out.println("Intentando depositar -$50.0 en CTA-001: " + cuenta1.depositar(-50.0));
        cuenta1.mostrarInfo();

        // 2. Probar Retiros
        System.out.println("\n--- Probando Retiros ---");
        System.out.println("Retirando $150.0 de CTA-001: " + cuenta1.retirar(150.0));
        System.out.println("Intentando retirar $1000.0 de CTA-001 (Sobregiro): " + cuenta1.retirar(1000.0));
        cuenta1.mostrarInfo();

        // 3. Probar Transferencia Atómica
        System.out.println("\n--- Probando Transferencia Atómica ---");
        System.out.println("Transferir $200.0 de CTA-001 a CTA-002: " + cuenta1.transferir(cuenta2, 200.0));

        System.out.println("\nEstado tras transferencia exitosa:");
        cuenta1.mostrarInfo();
        cuenta2.mostrarInfo();

        System.out.println("\nIntentando transferir $500.0 de CTA-001 a CTA-002 (Saldo insuficiente): "
                + cuenta1.transferir(cuenta2, 500.0));

        System.out.println("\n--- Estado Final ---");
        cuenta1.mostrarInfo();
        cuenta2.mostrarInfo();
    }
}