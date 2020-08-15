package org.baits.v1.conf;

/**
 * session
 */
public class SqlSession {

    private final Configuration configuration;
    private final Executor executor;

    public SqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    /**
     * 调用执行器，执行查询
     *
     * @param statementId
     * @param parameters
     * @param <T>
     * @return
     */
    public <T> T selectOne(String statementId, Object parameters) {
        // org.baits.mapper.BlogMapper.getBlogById
        String sql = Configuration.sqlMappings.getString(statementId);
        return executor.query(sql, parameters);
    }

    /**
     * 获取一个代理对象
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<?> clazz) {
        return configuration.getMapper(clazz, this);
    }
}
