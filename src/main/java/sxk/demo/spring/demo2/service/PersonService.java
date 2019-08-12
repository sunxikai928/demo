package sxk.demo.spring.demo2.service;

import org.springframework.stereotype.Service;
import sxk.demo.spring.demo2.pojo.Person;

/**
 * Created by sunxikai on 19/8/9.
 */
@Service
public class PersonService implements IPersonService {
    @Override
    public Person getPerson() {
        return new Person("李四", 1);
    }
}
