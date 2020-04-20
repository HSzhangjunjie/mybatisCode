package com.framework.mapping;

import java.util.Map;

/**
 * @ProjectName: mybatisCode
 * @Package: com.framework.mapping
 * @ClassName: Configuration
 * @Author: ZhangJunjie
 * @Description:
 * @Date: 2020/4/21 0:37
 * @Version: 1.0
 */
public class Configuration {
    //mybatis-config.xml
    private Environment environment;
    //Mapper.xml
    private Map<String,MapperStatement> mapperStatementMap;

    public Configuration(Environment environment, Map<String, MapperStatement> mapperStatementMap) {
        this.environment = environment;
        this.mapperStatementMap = mapperStatementMap;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public Map<String, MapperStatement> getMapperStatementMap() {
        return mapperStatementMap;
    }

    public void setMapperStatementMap(Map<String, MapperStatement> mapperStatementMap) {
        this.mapperStatementMap = mapperStatementMap;
    }
}
