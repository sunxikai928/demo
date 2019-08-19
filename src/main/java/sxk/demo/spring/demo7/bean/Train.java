package sxk.demo.spring.demo7.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class Train implements InitializingBean, DisposableBean {
    public Train() {
        System.out.println("Train 的构造方法");
    }

    /**
     * 容器销毁的时候会执行的方法
     */
    @Override
    public void destroy() {
        System.out.println("Train 的 destroy 方法");
    }

    /**
     * 当属性都被赋值的时候调用
     * 会在创建bean中，属性赋值之后执行
     * 在 AbstractAutowireCapableBeanFactory 中的 doCreateBean 中的 initializeBean
     * 最终在这个方法中调用 {@link AbstractAutowireCapableBeanFactory#invokeInitMethods}
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Train 的 afterPropertiesSet 方法");
    }
}
