package org.baits.v1.proxy;

import org.baits.v1.conf.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperProxy implements InvocationHandler {

    private final SqlSession sqlSession;

    public MapperProxy(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String statementId = method.getDeclaringClass().getName() + "." + method.getName();
        return sqlSession.selectOne(statementId, args[0]);
    }
}
