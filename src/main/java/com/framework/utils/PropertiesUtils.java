package com.framework.utils;

import com.framework.mapping.Environment;
import com.framework.mapping.MapperStatement;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ProjectName: mybatisCode
 * @Package: com.framework.properties
 * @ClassName: PropertiesUtils
 * @Author: ZhangJunjie
 * @Description:
 * @Date: 2020/4/21 1:16
 * @Version: 1.0
 */
public class PropertiesUtils {

    public static Environment setEnvironment(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(inputStream);
        Environment environment = new Environment();
        environment.setDriver(properties.getProperty("driver"));
        environment.setUrl(properties.getProperty("url"));
        environment.setPassword(properties.getProperty("password"));
        environment.setUsername(properties.getProperty("username"));
        environment.setMappers(properties.getProperty("mapper.resource"));
        return environment;
    }

    public static MapperStatement setStatement(String resource) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = MapperStatement.class.getClassLoader().getResourceAsStream(resource);
        properties.load(inputStream);
        MapperStatement statement = new MapperStatement();
        statement.setId(properties.getProperty("id"));
        statement.setParameterType(properties.getProperty("parameterType"));
        statement.setNamespace(properties.getProperty("namespace"));
        statement.setResultType(properties.getProperty("resultType"));
        statement.setSql(properties.getProperty("sql"));
        return statement;
    }
}
