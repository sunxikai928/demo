package sxk.demo.spring.demo8.bean;

import org.springframework.stereotype.Component;

/**
 * @author : sunxikai
 * @date : 2019-08-22
 */
public class Dove2 {
    private String name = "defaultDove2";

    public Dove2() {
    }

    public Dove2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dove2{" +
                "name='" + name + '\'' +
                '}';
    }
}
