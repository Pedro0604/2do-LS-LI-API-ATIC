package ar.edu.unlp.oo1.ejercicio10;

public class FIFOStrategy implements SchedulerStrategyComparer {

	@Override
	public int compareJob(JobDescription job1, JobDescription job2) {
		return Integer.compare(job2.index(), job1.index());
	}
}
