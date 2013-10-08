/**
 * 
 */
package home.otv.monitor.srv;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author X075027
 * 
 */
public interface IThreadPoolMonitorService extends Runnable {

	public void monitorThreadPool();

	public ThreadPoolExecutor getExecutor();

	public void setExecutor(ThreadPoolExecutor executor);
}
