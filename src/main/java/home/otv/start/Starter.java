/**
 * 
 */
package home.otv.start;

import java.util.concurrent.ThreadPoolExecutor;

import home.otv.handler.TestRejectedExecutionHandler;
import home.otv.monitor.srv.IThreadPoolMonitorService;
import home.otv.srv.ITestThreadPoolExecutorService;
import home.otv.task.TestTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author X075027
 * Starter class
 * 
 */
public class Starter {

	private static Logger log = LoggerFactory
			.getLogger(TestRejectedExecutionHandler.class);

	IThreadPoolMonitorService threadPoolMonitorService;
	ITestThreadPoolExecutorService testThreadPoolExecutorService;

	public void start() {

		// A new thread pool is created...
		ThreadPoolExecutor executor = testThreadPoolExecutorService
				.createNewThreadPool();
		executor.allowCoreThreadTimeOut(true);

		// Created executor is set to ThreadPoolMonitorService...
		threadPoolMonitorService.setExecutor(executor);

		// ThreadPoolMonitorService is started...
		Thread monitor = new Thread(threadPoolMonitorService);
		monitor.start();

		// New tasks are executed...
		for (int i = 1; i < 10; i++) {
			executor.execute(new TestTask("Task" + i));
		}

		try {
			Thread.sleep(40000);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		for (int i = 10; i < 19; i++) {
			executor.execute(new TestTask("Task" + i));
		}

		// executor is shutdown...
		executor.shutdown();
	}

	public IThreadPoolMonitorService getThreadPoolMonitorService() {
		return threadPoolMonitorService;
	}

	public void setThreadPoolMonitorService(
			IThreadPoolMonitorService threadPoolMonitorService) {
		this.threadPoolMonitorService = threadPoolMonitorService;
	}

	public ITestThreadPoolExecutorService getTestThreadPoolExecutorService() {
		return testThreadPoolExecutorService;
	}

	public void setTestThreadPoolExecutorService(
			ITestThreadPoolExecutorService testThreadPoolExecutorService) {
		this.testThreadPoolExecutorService = testThreadPoolExecutorService;
	}

}
