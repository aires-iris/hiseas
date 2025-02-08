package cn.com.hiseas.satoken;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.lang.NonNull;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Objects;

/**
 * yaml 配置源 工厂
 *
 * @author zhengxiang
 * @date 2025/1/16 00:51
 * @since 0.0.1
 */
public class YamlPropertySourceFactory extends DefaultPropertySourceFactory {

    @Override
    @NonNull
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        String filename = resource.getResource().getFilename();
        if (StringUtils.hasLength(filename) && (filename.endsWith(".yml") || filename.endsWith(".yaml"))) {
            YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
            factoryBean.setResources(resource.getResource());
            factoryBean.afterPropertiesSet();
            return new PropertiesPropertySource(filename, Objects.requireNonNull(factoryBean.getObject()));
        }
        return super.createPropertySource(name, resource);
    }

}
