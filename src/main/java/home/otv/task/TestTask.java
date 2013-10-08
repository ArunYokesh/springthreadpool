/**
 * 
 */
package home.otv.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author X075027
 * @since 7 Oct 2013
 * @version 1.0.0
 * 
 */
public class TestTask implements Runnable {

	private static Logger log = LoggerFactory.getLogger(TestTask.class);
	String taskName;

	public TestTask() {
	}

	public TestTask(String taskName) {
		this.taskName = taskName;
	}

	public void run() {
		try {
			log.debug(this.taskName + " : is started.");
			Thread.sleep(10000);
			log.debug(this.taskName + " : is completed.");
		} catch (InterruptedException e) {
			log.error(this.taskName + " : is not completed!");
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return (getTaskName());
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
}
