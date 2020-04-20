package com.framework.mapping;

/**
 * @ProjectName: mybatisCode
 * @Package: com.framework.mapping
 * @ClassName: Evironment
 * @Author: ZhangJunjie
 * @Description:
 * @Date: 2020/4/21 0:58
 * @Version: 1.0
 */
public class Environment {
    private String driver;
    private String url;
    private String username;
    private String password;
    private String mappers;

    public String getMappers() {
        return mappers;
    }

    public void setMappers(String mappers) {
        this.mappers = mappers;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
