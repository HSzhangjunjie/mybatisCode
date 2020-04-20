package com.framework.session;

import com.framework.executor.Executor;
import com.framework.mapping.Configuration;
import com.framework.mapping.MapperStatement;
import com.framework.proxy.MapperProxy;

import java.lang.reflect.Proxy;
import java.util.List;


/**
 * @ProjectName: mybatisCode
 * @Package: com.framework.session
 * @ClassName: SqlSession
 * @Author: ZhangJunjie
 * @Description:
 * @Date: 2020/4/21 0:20
 * @Version: 1.0
 */
public class SqlSession {
    private Configuration configuration;
    private Executor executor;

    public SqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T getMapper(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]{clazz}, new MapperProxy(this));
    }

    public <T> T selectOne(String key, Object param) {
        MapperStatement statement = configuration.getMapperStatementMap().get(key);
        List<T> resultList = executor.query(statement, param);
        if (resultList != null && resultList.size() > 1) {
            throw new RuntimeException("结果不唯一！");
        } else {
            return resultList.get(0);
        }

    }
}
