package ar.edu.unlp.oo1.ejercicio9;

public abstract class Cuenta {
	private double saldo;

	public Cuenta() {
		this.saldo = 0;
	}

	public double getSaldo() {
		return saldo;
	}

	public void depositar(double monto) {
		this.saldo += monto;
	}

	public boolean extraer(double monto) {
		if (puedeExtraer(monto)) {
			this.extraerSinControlar(monto);
			return true;
		}
		return false;
	}

	public boolean transferirACuenta(double monto, Cuenta cuentaDestino) {
		if (puedeExtraer(monto)) {
			this.extraerSinControlar(monto);
			cuentaDestino.depositar(monto);
			return true;
		}
		return false;
	}

	public abstract boolean puedeExtraer(double monto);

	public void extraerSinControlar(double monto) {
		this.saldo -= monto;
	}
}
