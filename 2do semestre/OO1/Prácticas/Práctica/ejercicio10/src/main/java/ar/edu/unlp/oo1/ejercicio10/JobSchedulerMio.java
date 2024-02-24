package ar.edu.unlp.oo1.ejercicio10;

import java.util.ArrayList;
import java.util.List;

public class JobSchedulerMio {
	private String strategy;
	private List<JobDescription> jobs;
	private int actual;

	public JobSchedulerMio(String strategy) {
		this.strategy = strategy;
		this.actual = 0;
		this.jobs = new ArrayList<>();
	}

	public void schedule(JobDescription job) {
		this.jobs.add(job);
	}

	public void unSchedule(JobDescription job) {
		this.jobs.remove(job);
	}

	public JobDescription next() {
		return this.jobs.stream()
				.max((j1, j2) -> Integer.compare(j1.priority(), j2.priority()) == 0
						? Double.compare(j2.effort(), j1.effort())
						: Integer.compare(j1.priority(), j2.priority()))
				.orElse(null);
	}
}
