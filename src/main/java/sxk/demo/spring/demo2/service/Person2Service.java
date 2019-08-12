package sxk.demo.spring.demo2.service;

import org.springframework.stereotype.Service;
import sxk.demo.spring.demo2.pojo.Person;

/**
 * Created by sunxikai on 19/8/9.
 */
@Service
public class Person2Service implements IPersonService {
    @Override
    public Person getPerson() {
        return new Person("张三", 2);
    }
}
