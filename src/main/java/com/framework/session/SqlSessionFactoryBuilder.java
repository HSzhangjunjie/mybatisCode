package com.framework.session;

import com.framework.mapping.Configuration;
import com.framework.mapping.Environment;
import com.framework.mapping.MapperStatement;
import com.framework.utils.PropertiesUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: mybatisCode
 * @Package: com.framework.session
 * @ClassName: SqlSessionFactoryBuilder
 * @Author: ZhangJunjie
 * @Description:
 * @Date: 2020/4/21 0:20
 * @Version: 1.0
 */
public class SqlSessionFactoryBuilder {
    private Environment environment;
    private Map<String, MapperStatement> mapperStatementMap = new HashMap<>();

    /**
     * description: 根据输入流构建SqlSessionFactory对象
     * create time: 0:35 2020/4/21
     */
    public SqlSessionFactory build(InputStream inputStream) throws IOException {

        //解析XML文件(这里用的是Properties)，构建configuration对象

        environment = PropertiesUtils.setEnvironment(inputStream);
        MapperStatement statement = PropertiesUtils.setStatement(environment.getMappers());
        String key = statement.getNamespace() + "." + statement.getId();
        mapperStatementMap.put(key, statement);
        Configuration configuration = new Configuration(environment, mapperStatementMap);

        return new SqlSessionFactory(configuration);
    }
}
