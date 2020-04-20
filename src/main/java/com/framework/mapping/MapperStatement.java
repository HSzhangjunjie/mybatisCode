package com.framework.mapping;

/**
 * @ProjectName: mybatisCode
 * @Package: com.framework.mapping
 * @ClassName: MapperStatement
 * @Author: ZhangJunjie
 * @Description:
 * @Date: 2020/4/21 0:58
 * @Version: 1.0
 */
public class MapperStatement {
    private String sql;
    private String id;
    private String namespace;
    private String parameterType;
    private String resultType;

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
