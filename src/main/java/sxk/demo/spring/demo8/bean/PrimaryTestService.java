package sxk.demo.spring.demo8.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author : sunxikai
 * @date : 2019-08-22
 */
@Component
public class PrimaryTestService {
    @Autowired
    private IPrimaryTest primaryTest;
    @Resource
    private IPrimaryTest primaryTest1;

    public void test() {
        System.out.println(primaryTest);
    }

    public void test1() {
        System.out.println(primaryTest1);
    }

}
