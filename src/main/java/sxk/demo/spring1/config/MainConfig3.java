package sxk.demo.spring1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;

/**
 * spring配置了类
 * <p>
 * Created by sunxikai on 19/8/9.
 */
// 注解该类是一个配置类
@Configuration
// 可以配置多个 ComponentScan
@ComponentScans(value = {
        // 指定扫描包
        @ComponentScan(value = "sxk.demo.spring1.dao"),
        // 配置其它类型的扫描
        @ComponentScan(
                value = "sxk.demo.spring1.service",
                useDefaultFilters = false,
                includeFilters = {
                        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Service.class})
                }
        )
})
public class MainConfig3 {

}
