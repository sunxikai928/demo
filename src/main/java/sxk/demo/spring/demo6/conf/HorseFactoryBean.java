package sxk.demo.spring.demo6.conf;

import org.springframework.beans.factory.FactoryBean;
import sxk.demo.spring.demo6.pojo.Horse;

public class HorseFactoryBean implements FactoryBean<Horse> {
    @Override
    public Horse getObject() throws Exception {
        return new Horse();
    }

    @Override
    public Class<?> getObjectType() {
        return Horse.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
