package sxk.demo.spring.demo8.bean;

import org.springframework.stereotype.Component;

/**
 * @author : sunxikai
 * @date : 2019-08-22
 */
@Component
public class Dove {
    private String name = "defaultDove";

    public Dove() {
    }

    public Dove(String name) {
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
        return "Dove{" +
                "name='" + name + '\'' +
                '}';
    }
}
