package sxk.demo.spring.demo6.conf;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class DemoImportSelector implements ImportSelector {
    /**
     * 返回的数组中的类都会被加载到容器中，必须是类的全路径，类的全名会作为容器中的key
     *
     * @param importingClassMetadata 这里会传配置类进来 sxk.demo.spring1.demo6.conf.DemoConfig6
     * @return 这个方法不能返回null，否则报空指针，可以返回空数组
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("DemoImportSelector#selectImports 被调用了; className:" + importingClassMetadata.getClassName());
        return new String[]{"sxk.demo.spring.demo6.pojo.Pig"};
    }
}
