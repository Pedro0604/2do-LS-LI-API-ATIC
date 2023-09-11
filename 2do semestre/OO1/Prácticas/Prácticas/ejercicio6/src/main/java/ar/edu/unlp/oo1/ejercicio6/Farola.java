package ar.edu.unlp.oo1.ejercicio6;

import java.util.ArrayList;
import java.util.List;

public class Farola {
	private List<Farola> neighbors;
	private boolean on;

	public Farola() {
		this.on = false;
		this.neighbors = new ArrayList<Farola>();
	}

	public void pairWithNeighbor(Farola otraFarola) {
		this.addNeighbor(otraFarola);
		otraFarola.addNeighbor(this);
	}

	public void addNeighbor(Farola otraFarola) {
		this.neighbors.add(otraFarola);
	}

	public List<Farola> getNeighbors() {
		return neighbors;
	}

	public void turnOn() {
		if (!this.isOn()) {
			this.setOn(true);
			this.getNeighbors().stream().forEach(farola -> farola.turnOn());
		}
	}

	public void turnOff() {
		if (this.isOn()) {
			this.setOn(false);
			this.getNeighbors().stream().forEach(farola -> farola.turnOff());
		}
	}

	public void setOn(boolean b) {
		this.on = b;
	}

	public boolean isOn() {
		return on;
	}
}
