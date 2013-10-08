/**
 * 
 */
package home.otv.srv;

import home.otv.handler.TestRejectedExecutionHandler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * The Class TestThreadPoolExecutorService.
 * 
 * @author X075027
 */
public class TestThreadPoolExecutorService implements
		ITestThreadPoolExecutorService {

	/** The core pool size. */
	private int corePoolSize;

	/** The max pool size. */
	private int maxPoolSize;

	/** The keep alive time. */
	private long keepAliveTime;

	/** The queue capacity. */
	private int queueCapacity;

	/** The test rejected execution handler. */
	TestRejectedExecutionHandler testRejectedExecutionHandler;

	/*
	 * (non-Javadoc)
	 * 
	 * @see home.otv.srv.ITestThreadPoolExecutorService#createNewThreadPool()
	 */
	@Override
	public ThreadPoolExecutor createNewThreadPool() {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(getCorePoolSize(),
				getMaxPoolSize(), getKeepAliveTime(), TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(getQueueCapacity()),
				getTestRejectedExecutionHandler());
		return executor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see home.otv.srv.ITestThreadPoolExecutorService#getCorePoolSize()
	 */
	@Override
	public int getCorePoolSize() {
		return this.corePoolSize;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see home.otv.srv.ITestThreadPoolExecutorService#setCorePoolSize(int)
	 */
	@Override
	public void setCorePoolSize(int corePoolSize) {
		this.corePoolSize = corePoolSize;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see home.otv.srv.ITestThreadPoolExecutorService#getMaxPoolSize()
	 */
	@Override
	public int getMaxPoolSize() {
		return maxPoolSize;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see home.otv.srv.ITestThreadPoolExecutorService#setMaxPoolSize(int)
	 */
	@Override
	public void setMaxPoolSize(int maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see home.otv.srv.ITestThreadPoolExecutorService#getKeepAliveTime()
	 */
	@Override
	public long getKeepAliveTime() {
		return keepAliveTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see home.otv.srv.ITestThreadPoolExecutorService#setKeepAliveTime(long)
	 */
	@Override
	public void setKeepAliveTime(long keepAliveTime) {
		this.keepAliveTime = keepAliveTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see home.otv.srv.ITestThreadPoolExecutorService#getQueueCapacity()
	 */
	@Override
	public int getQueueCapacity() {
		return queueCapacity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see home.otv.srv.ITestThreadPoolExecutorService#setQueueCapacity(int)
	 */
	@Override
	public void setQueueCapacity(int queueCapacity) {
		this.queueCapacity = queueCapacity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * home.otv.srv.ITestThreadPoolExecutorService#getTestRejectedExecutionHandler
	 * ()
	 */
	@Override
	public TestRejectedExecutionHandler getTestRejectedExecutionHandler() {
		return testRejectedExecutionHandler;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * home.otv.srv.ITestThreadPoolExecutorService#setTestRejectedExecutionHandler
	 * (home.otv.handler.TestRejectedExecutionHandler)
	 */
	@Override
	public void setTestRejectedExecutionHandler(
			TestRejectedExecutionHandler testRejectedExecutionHandler) {
		this.testRejectedExecutionHandler = testRejectedExecutionHandler;
	}

}
