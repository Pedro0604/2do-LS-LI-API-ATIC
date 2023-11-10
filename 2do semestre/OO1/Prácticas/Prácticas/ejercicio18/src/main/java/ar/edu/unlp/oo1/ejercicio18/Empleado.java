package ar.edu.unlp.oo1.ejercicio18;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empleado {
	private String nombre, apellido, cuil;
	private LocalDate fechaNacimiento, inicioRelacionLaboral;
	private boolean tieneConyugeACargo, tieneHijosACargo;
	private List<Contrato> contratos;

	public Empleado(String nombre, String apellido, String cuil, LocalDate fechaNacimiento, boolean tieneConyugeACargo,
			boolean tieneHijosACargo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuil = cuil;
		this.fechaNacimiento = fechaNacimiento;
		this.tieneConyugeACargo = tieneConyugeACargo;
		this.tieneHijosACargo = tieneHijosACargo;
		this.inicioRelacionLaboral = LocalDate.now();
		this.contratos = new ArrayList<>();
	}

	public boolean tieneComoCuil(String cuil) {
		return this.cuil.equals(cuil);
	}

	public Contrato getContratoActivo() {
		return this.contratos.stream().filter(c -> c.isActivo()).findFirst().orElse(null);
	}

	public boolean hasContratoActivo() {
		return this.getContratoActivo() != null;
	}

	public ContratoPorHoras cargarContratoPorHoras(LocalDate fechaInicio, LocalDate fechaFin, double valorPorHora,
			int cantHorasMes) {
		if (!this.hasContratoActivo()) {
			ContratoPorHoras nuevoContrato = new ContratoPorHoras(this, fechaInicio, fechaFin, valorPorHora,
					cantHorasMes);
			this.contratos.add(nuevoContrato);
			return nuevoContrato;
		} else {
			return null;
		}
	}

	public ContratoDePlanta cargarContratoDePlanta(LocalDate fechaInicio, double sueldoMensual, double montoPorConyuge,
			double montoPorHijos) {
		if (!this.hasContratoActivo()) {
			ContratoDePlanta nuevoContrato = new ContratoDePlanta(this, fechaInicio, sueldoMensual,
					this.tieneConyugeACargo ? montoPorConyuge : 0, this.tieneHijosACargo ? montoPorHijos : 0);
			this.contratos.add(nuevoContrato);
			return nuevoContrato;
		} else {
			return null;
		}
	}

	public Contrato getContratoActual() {
		return this.contratos.stream().max((c1, c2) -> c1.getFechaInicio().compareTo(c2.getFechaInicio())).orElse(null);
	}

	public boolean contratoActualEstaVencido() {
		return this.getContratoActual() != null && this.getContratoActual().isVencido();
	}

	public int getAntiguedad() {
		int antiguedadEnDias = this.contratos.stream().mapToInt(c -> c.getDuracionEnDias()).sum();
		return antiguedadEnDias / 365;
	}

	public double getAumentoAntiguedad() {
		int ant = this.getAntiguedad();
		return ant < 5 ? 0 : ant < 10 ? 0.3 : ant < 15 ? 0.5 : ant < 20 ? 0.7 : 1;
	}

	public Recibo generarReciboDeSueldo() {
		double basico = this.getContratoActivo().getBasico();
		double montoTotal = basico + basico * this.getAumentoAntiguedad();
		return (new Recibo(nombre, apellido, cuil, getAntiguedad(), montoTotal));
	}

	public List<Contrato> getContratos() {
		return contratos;
	}
}
