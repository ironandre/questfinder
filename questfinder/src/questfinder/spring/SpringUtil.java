package questfinder.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
    private static ClassPathXmlApplicationContext applicationContext;
    static {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("questfinder/spring/springbeans.xml");
			applicationContext = context;
    }
	public static ClassPathXmlApplicationContext getApplicationContext() {
		return applicationContext;
	}

}
