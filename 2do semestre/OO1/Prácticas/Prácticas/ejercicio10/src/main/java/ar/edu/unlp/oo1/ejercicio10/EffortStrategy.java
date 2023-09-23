package ar.edu.unlp.oo1.ejercicio10;

public class EffortStrategy implements SchedulerStrategyComparer {

	@Override
	public int compareJob(JobDescription job1, JobDescription job2) {
		return Double.compare(job1.effort(), job2.effort());
	}
}
