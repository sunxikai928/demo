package sxk.demo.spring.demo6.conf;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class DemoImportSelector implements ImportSelector {
    /**
     * 这个方法不能放回null，否则报空指针，可以返回空数组
     * 返回的数组中的类都会被加载到容器中
     * importingClassMetadata 会传 sxk.demo.spring1.demo6.conf.DemoConfig6
     * @param importingClassMetadata 配置类
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("DemoImportSelector#selectImports 被调用了; className:" + importingClassMetadata.getClassName());
        return new String[]{"sxk.demo.spring1.demo6.pojo.Pig"};
    }
}
