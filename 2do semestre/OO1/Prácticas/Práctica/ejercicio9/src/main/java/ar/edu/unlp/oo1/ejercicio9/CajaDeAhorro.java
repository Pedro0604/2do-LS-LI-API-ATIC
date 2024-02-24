package ar.edu.unlp.oo1.ejercicio9;

public class CajaDeAhorro extends Cuenta {
	private double costoAdicional;

	public CajaDeAhorro() {
		super();
		this.costoAdicional = 0.02;
	}

	@Override
	public boolean puedeExtraer(double monto) {
		return (this.saldo) >= monto * (1 + costoAdicional);
	}

	@Override
	public void extraerSinControlar(double monto) {
		super.extraerSinControlar(monto * (1 + costoAdicional));
	}
}
