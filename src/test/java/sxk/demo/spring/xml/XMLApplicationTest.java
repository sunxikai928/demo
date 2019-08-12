package sxk.demo.spring.xml;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sxk.demo.spring.demo2.pojo.Person;

/**
 * Created by sunxikai on 19/8/8.
 */
public class XMLApplicationTest {
    @Test
    public void test() {
        /*
        通过xml配置spring
         */
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("application.xml");
        Person person = (Person) app.getBean("person");
        System.out.println("姓名:" + person.getName() + ",年龄:" + person.getAge());
    }
}
