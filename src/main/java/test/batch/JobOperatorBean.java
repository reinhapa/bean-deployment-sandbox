package test.batch;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.batch.operations.JobOperator;
import javax.batch.operations.JobSecurityException;
import javax.batch.operations.JobStartException;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.JobExecution;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.slf4j.Logger;

@Stateless
public class JobOperatorBean {
  @Inject
  Logger logger;

  private JobOperator jobOperator;

  @PostConstruct
  public void initialize() {
    jobOperator = BatchRuntime.getJobOperator();
  }

  public Long start(String jobXMLName, Properties jobParameters) {
    logger.info("Start batch job: {}", jobXMLName);
    return jobOperator.start(jobXMLName, jobParameters);
  }

  public JobExecution getJobExecution(Long executionId) {
    return jobOperator.getJobExecution(executionId);
  }

  @Schedule(hour = "*", minute = "*/1", persistent = false)
  public void onTimer() {
    try {
      start("batch.xml", new Properties());
      start("junkedbatch.xml", new Properties());
    } catch (JobStartException | JobSecurityException e) {
      logger.error("Unable to start: " + e.getMessage());
    }
  }
}
