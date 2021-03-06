package sxk.demo.spring.demo6.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import sxk.demo.spring.demo6.pojo.Cat;
import sxk.demo.spring.demo6.pojo.Dog;

@Configuration
@Import(value = {
        // 以类的全名为容器中的key
        Cat.class,
        /*
         自定义注册bean
         ImportBeanDefinitionRegistrar 会被最后才加入到 bean 容器，但是如果有多个 ImportBeanDefinitionRegistrar 会不知道顺序
         */
        DemoImportBeanDefinitionRegistrar.class,
        // 以类的全名为容器中的key，返回类名数组，数组中的类会被全部加载到容器中
        DemoImportSelector.class,
        /*
         这种方式，会以 FactoryBean 的全名为key，但实际上类型是需要生成的类型：Tiger
         */
        TigerFactoryBean.class
})
public class DemoConfig6 {

    /*
    @Bean
    当value有值的时候 value 的值就是容器中的 key
    当value有没有值的时候 方法名 就是容器中的 key
     */
    @Bean(value = "littleDog")
    public Dog littleDog() {
        return new Dog();
    }

    @Bean
    public Dog dog() {
        return new Dog();
    }

    /*
    这里表面上加载的是 HorseFactoryBean 实际上加载到容器中的类型是 Horse
    通过这种方式加载的对象，容器中的 key 是方法名
     */
    @Bean
    public HorseFactoryBean horse() {
        return new HorseFactoryBean();
    }
}
