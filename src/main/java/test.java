import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

public class test {
	public static void main(String[] args) {
		ApplicationContext c = new ClassPathXmlApplicationContext("hib-template.xml");
		System.out.println(c.getBean(HibernateTemplate.class));
	}
}
