package com.framework.session;


import com.framework.mapping.Configuration;
import com.framework.executor.Executor;

/**
 * @ProjectName: mybatisCode
 * @Package: com.framework.session
 * @ClassName: SqlSessionFactory
 * @Author: ZhangJunjie
 * @Description:
 * @Date: 2020/4/21 0:20
 * @Version: 1.0
 */
public class SqlSessionFactory {

    private Configuration configuration;

    public SqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    public SqlSession openSession() {
        Executor executor = new Executor(configuration);
        return new SqlSession(configuration, executor);
    }
}
