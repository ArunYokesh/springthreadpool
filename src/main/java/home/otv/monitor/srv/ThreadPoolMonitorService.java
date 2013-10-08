/**
 * 
 */
package home.otv.monitor.srv;

import java.util.concurrent.ThreadPoolExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class ThreadPoolMonitorService.
 * 
 * @author X075027
 */
public class ThreadPoolMonitorService implements IThreadPoolMonitorService {

	/** The log. */
	private static Logger log = LoggerFactory
			.getLogger(ThreadPoolMonitorService.class);

	/** The executor. */
	ThreadPoolExecutor executor;

	/** The monitoring period. */
	private long monitoringPeriod;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		try {
			while (true) {
				monitorThreadPool();
				Thread.sleep(monitoringPeriod * 1000);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see home.otv.monitor.srv.IThreadPoolMonitorService#monitorThreadPool()
	 */
	public void monitorThreadPool() {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("CurrentPoolSize : ").append(executor.getPoolSize());
		strBuff.append(" - CorePoolSize : ").append(executor.getCorePoolSize());
		strBuff.append(" - MaximumPoolSize : ").append(
				executor.getMaximumPoolSize());
		strBuff.append(" - ActiveTaskCount : ").append(
				executor.getActiveCount());
		strBuff.append(" - CompletedTaskCount : ").append(
				executor.getCompletedTaskCount());
		strBuff.append(" - TotalTaskCount : ").append(executor.getTaskCount());
		strBuff.append(" - isTerminated : ").append(executor.isTerminated());

		log.debug(strBuff.toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see home.otv.monitor.srv.IThreadPoolMonitorService#getExecutor()
	 */
	public ThreadPoolExecutor getExecutor() {
		return executor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * home.otv.monitor.srv.IThreadPoolMonitorService#setExecutor(java.util.
	 * concurrent.ThreadPoolExecutor)
	 */
	public void setExecutor(ThreadPoolExecutor executor) {
		this.executor = executor;
	}

	/**
	 * Gets the monitoring period.
	 * 
	 * @return the monitoring period
	 */
	public long getMonitoringPeriod() {
		return monitoringPeriod;
	}

	/**
	 * Sets the monitoring period.
	 * 
	 * @param monitoringPeriod
	 *            the new monitoring period
	 */
	public void setMonitoringPeriod(long monitoringPeriod) {
		this.monitoringPeriod = monitoringPeriod;
	}

}
