package com.framework.proxy;

import com.framework.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

/**
 * @ProjectName: mybatisCode
 * @Package: com.framework.proxy
 * @ClassName: MapperProxy
 * @Author: ZhangJunjie
 * @Description:
 * @Date: 2020/4/21 2:41
 * @Version: 1.0
 */
public class MapperProxy implements InvocationHandler {
    private SqlSession sqlSession;

    public MapperProxy(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        //拦截真正的数据库操作
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        }

        Class<?> clazz = method.getReturnType();

        //如果返回类型是集合类型的子类
        if (Collection.class.isAssignableFrom(clazz)) {
            //表示要查询多条数据返回List
            return null;
        } else if (Map.class.isAssignableFrom(clazz)) {
            //表示要返回Map集合
            return null;
        } else {
            //返回对象数据namespace.selectId
            String statementKey = method.getDeclaringClass().getName() + "." + method.getName();
            return sqlSession.selectOne(statementKey, null == args ? null : args[0]);
        }
    }
}
