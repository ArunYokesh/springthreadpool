/**
 * 
 */
package home.otv.start;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author X075027
 * @since 7 Oct 2013
 * @version 1.0.0
 * 
 */
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		//start
		//start starter
		Starter starter = (Starter) context.getBean("Starter");
		starter.start();
	}

}
