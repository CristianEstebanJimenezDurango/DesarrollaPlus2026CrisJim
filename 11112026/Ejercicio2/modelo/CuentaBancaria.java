package Ejercicio2.modelo;
public class CuentaBancaria {
    private String numeroCuenta;
    private final String titular;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
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

    public boolean depositar(double monto) {
        if (monto <= 0) return false;
        saldo += monto;
        return true;
    }

    public boolean retirar(double monto) {
        if (monto <= 0 || monto > saldo) 
            return false;
        saldo -= monto;
        return true;
    }

    public boolean transferir(CuentaBancaria destino, double monto) {
        if (destino != null && retirar(monto)) {
            return destino.depositar(monto);
        }
        return false;
    }
}