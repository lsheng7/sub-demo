package com.example.subdemo.spring.typefilter;

import cn.hutool.core.util.ClassUtil;
import java.io.IOException;
import java.util.Properties;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.filter.AbstractTypeHierarchyTraversingFilter;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.ClassUtils;
import org.springframework.util.PathMatcher;

public final class AreaSpringExcludeTypeFilter extends AbstractTypeHierarchyTraversingFilter {

    // 潜在的满足条件的类的类名, 指定package下
    private static final String PATTERN_STANDARD = ClassUtils.convertClassNameToResourcePath("com.example.subdemo.spring.typefilter.*");
    private PathMatcher pathMatcher;
    // 注意下面这种方式是获取不到配置值的, 具体原因下面解释
    //@Value("${common.area.name}")
    private String configedAreaName;

    public AreaSpringExcludeTypeFilter() {
        // 不考虑基类, 也不考虑接口上的信息
        super(false, false);

        // 借助Spring默认的 Resource通配符路径 方式
        pathMatcher = new AntPathMatcher();

        // 硬编码读取配置信息
        try {
            Properties loadAllProperties = PropertiesLoaderUtils.loadAllProperties("area.properties");
            configedAreaName = loadAllProperties.getProperty("common.area.name");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 注意本类将注册为Exclude, 返回true代表拒绝
    @Override
    protected boolean matchClassName(String className) {
        if (!isPotentialPackageClass(className)) {
            return false;
        }

        // 判断当前区域是否和所配置的区域一致, 不一致则阻止载入Spring容器
        Class<?> clazz = ClassUtil.loadClass(className, false);
        Areaed areaedAnnotation = clazz.getAnnotation(Areaed.class);
        if (null == areaedAnnotation) {
            return false;
        }
        final String thisAreaName = areaedAnnotation.value();
        return (!configedAreaName.equalsIgnoreCase(thisAreaName));
    }

    // 本类逻辑中可以处理的类 -- 指定package下的才会进行逻辑判断,
    private boolean isPotentialPackageClass(String className) {
        // 将类名转换为资源路径, 以进行匹配测试
        final String path = ClassUtils.convertClassNameToResourcePath(className);
        return pathMatcher.match(PATTERN_STANDARD, path);
    }
}
