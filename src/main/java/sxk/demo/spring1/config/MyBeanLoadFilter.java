package sxk.demo.spring1.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import sxk.demo.spring1.service.IPersonService;

import java.io.IOException;

/**
 * Created by sunxikai on 19/8/9.
 */
public class MyBeanLoadFilter implements TypeFilter {

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 当前扫描的类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        // 当前被扫描类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        // 当前被扫描类资源信息
        Resource resource = metadataReader.getResource();
        String className = classMetadata.getClassName();
        System.out.println("className : " + className);
        Class clazz;
        try {
            clazz = Class.forName(className);
            // 判断该类是否是 IPersonService 的子类
            if (IPersonService.class.isAssignableFrom(clazz)) {
//               返回true就是加载该类
                return true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 返回 false 就是不加载
        return false;
    }
}
