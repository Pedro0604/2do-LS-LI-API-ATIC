package ar.edu.unlp.oo1.ejercicio10;

public class LIFOStrategy implements SchedulerStrategyComparer {

	@Override
	public int compareJob(JobDescription job1, JobDescription job2) {
		return Integer.compare(job1.index(), job2.index());
	}
}
