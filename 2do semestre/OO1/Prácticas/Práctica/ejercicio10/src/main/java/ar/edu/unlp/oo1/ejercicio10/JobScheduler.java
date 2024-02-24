package ar.edu.unlp.oo1.ejercicio10;

import java.util.ArrayList;
import java.util.List;

public class JobScheduler {
	protected List<JobDescription> jobs;
	protected SchedulerStrategyComparer strategy;

	public JobScheduler() {
		this.jobs = new ArrayList<>();
		this.strategy = new FIFOStrategy();
	}

	public void schedule(JobDescription job) {
		job.setIndex(this.jobs.size());
		this.jobs.add(job);
	}

	public void unschedule(JobDescription job) {
		if (job != null) {
			this.jobs.remove(job);
		}
	}

	public SchedulerStrategyComparer getStrategy() {
		return this.strategy;
	}

	public List<JobDescription> getJobs() {
		return jobs;
	}

	public void setStrategy(SchedulerStrategyComparer aStrategy) {
		this.strategy = aStrategy;
	}

	public JobDescription next() {
		JobDescription nextJob = this.jobs.stream().max((j1, j2) -> strategy.compareJob(j1, j2)).orElse(null);
		this.unschedule(nextJob);
		return nextJob;
	}
}
