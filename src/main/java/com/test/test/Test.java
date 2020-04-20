package com.test.test;

import com.framework.session.SqlSession;
import com.framework.session.SqlSessionFactory;
import com.framework.session.SqlSessionFactoryBuilder;
import com.test.mapper.UserInfoMapper;
import com.test.model.UserInfo;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ProjectName: mybatisCode
 * @Package: com.test.test
 * @ClassName: Test
 * @Author: ZhangJunjie
 * @Description:
 * @Date: 2020/4/20 20:33
 * @Version: 1.0
 */
public class Test {

    public static void main(String[] args) throws IOException {
        //读取mybatis-config.xml配置文件
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("mybatis-config.properties");
        //构建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //打开SqlSession
        SqlSession sqlSession = factory.openSession();
        //获取Mapper接口对象
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        //调用Mapper接口对象的方法操作数据库
        UserInfo info = userInfoMapper.selectByPrimaryKey(1);

        System.out.println("查询：" + info.getId() + "_name_" + info.getUsername() + "_age_" + info.getAge());
    }
}
