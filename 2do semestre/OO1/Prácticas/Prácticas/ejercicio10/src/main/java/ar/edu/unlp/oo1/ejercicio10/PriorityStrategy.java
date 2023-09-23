package ar.edu.unlp.oo1.ejercicio10;

public class PriorityStrategy implements SchedulerStrategyComparer {

	@Override
	public int compareJob(JobDescription job1, JobDescription job2) {
		return Integer.compare(job1.priority(), job2.priority());
	}
}
