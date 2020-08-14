package org.baits;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

/**
 * 全局配置文件
 */
public class Configuration {

    /**
     * sql 语句
     */
    public final static ResourceBundle sqlMappings;

    static {
        sqlMappings = ResourceBundle.getBundle("sql");
    }

    /**
     * 返回接口的代理类对象
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<?> clazz, SqlSession session) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz}, new MapperProxy(session));
    }
}
