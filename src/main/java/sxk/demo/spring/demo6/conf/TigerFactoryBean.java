package sxk.demo.spring.demo6.conf;

import org.springframework.beans.factory.FactoryBean;
import sxk.demo.spring.demo6.pojo.Tiger;

/**
 * 只要将这个类加入到容器中就会在容器中注册 Tiger。
 */
public class TigerFactoryBean implements FactoryBean<Tiger> {
    /**
     * 要生成的对象
     *
     * @return
     * @throws Exception
     */
    @Override
    public Tiger getObject() throws Exception {
        return new Tiger();
    }

    /**
     * 要生成的对象类型
     *
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Tiger.class;
    }

    /**
     * 是否单例
     *
     * @return
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
