package com.test.mapper;

import com.test.model.UserInfo;

/**
 * @ProjectName: mybatisCode
 * @Package: com.test.mapper
 * @ClassName: UUserInfoMapper
 * @Author: ZhangJunjie
 * @Description:
 * @Date: 2020/4/20 20:50
 * @Version: 1.0
 */
public interface UserInfoMapper {

    UserInfo selectByPrimaryKey(Integer id);

}
