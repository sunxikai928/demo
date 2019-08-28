package sxk.demo.spring.demo9.bean;

import org.springframework.stereotype.Component;

/**
 * @author : sunxikai
 * @date : 2019-08-27
 */
@Component
public class Sun {

    @Log
    public void shine() {
        System.out.println("Sun shine.");
    }

    @Log
    public void shine1() {
        int i = 1 / 0;
    }
}
