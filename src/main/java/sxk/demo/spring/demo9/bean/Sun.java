package sxk.demo.spring.demo9.bean;

import org.springframework.stereotype.Component;

/**
 * @author : sunxikai
 * @date : 2019-08-27
 */
@Component
public class Sun {

    @Log
    public String shine(int i) {
        System.out.println("Sun shine." + i);
        return "返回值";
    }

    @Log
    public void shine1(int n) {
        int i = 1 / n;
    }
}
