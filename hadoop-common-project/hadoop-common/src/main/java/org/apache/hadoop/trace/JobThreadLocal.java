package org.apache.hadoop.trace;

public class JobThreadLocal {
	public static final ThreadLocal<JobContext> userThreadLocal = new ThreadLocal<JobContext>();

    public static void set(JobContext user) {
    	userThreadLocal.set(user);
    }

    public static void unset() {
    	userThreadLocal.remove();
    }

    public static JobContext get() {
		return userThreadLocal.get();
    }

    public static String getJobId() {
  	  JobContext ctx = userThreadLocal.get();
  	  String jobId = "UNKNOWN";
  	  if (ctx != null && ctx.getJobId() != null)
  		  jobId = ctx.getJobId();
      return jobId;
    }
    
}
