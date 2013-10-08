/**
 * 
 */
package home.otv.srv;

import java.util.concurrent.ThreadPoolExecutor;
import home.otv.handler.TestRejectedExecutionHandler;

/**
 * @author X075027
 * 
 */
public interface ITestThreadPoolExecutorService {

	public ThreadPoolExecutor createNewThreadPool();

	public int getCorePoolSize();

	public void setCorePoolSize(int corePoolSize);

	public int getMaxPoolSize();

	public void setMaxPoolSize(int maximumPoolSize);

	public long getKeepAliveTime();

	public void setKeepAliveTime(long keepAliveTime);

	public int getQueueCapacity();

	public void setQueueCapacity(int queueCapacity);

	public TestRejectedExecutionHandler getTestRejectedExecutionHandler();

	public void setTestRejectedExecutionHandler(
			TestRejectedExecutionHandler testRejectedExecutionHandler);

}
