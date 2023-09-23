package ar.edu.unlp.oo1.ejercicio10;

public class JobDescription {
	private double effort;
	private int priority;
	private String description;
	private int index;

	public JobDescription(double effort, int priority, String description) {
		this.effort = effort;
		this.priority = priority;
		this.description = description;
	}

	public double effort() {
		return this.effort;
	}

	public int priority() {
		return this.priority;
	}

	public String description() {
		return this.description;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int index() {
		return this.index;
	}
}
