package com.test.model;

/**
 * @ProjectName: mybatisCode
 * @Package: com.test.model
 * @ClassName: UUserInfo
 * @Author: ZhangJunjie
 * @Description:
 * @Date: 2020/4/20 20:53
 * @Version: 1.0
 */
public class UserInfo {
    private Integer id;
    private String username;
    private Integer age;

    public UserInfo() {
    }

    public UserInfo(int id, String username, int age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UUserInfo{" +
                "id=" + id +
                ", name='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
