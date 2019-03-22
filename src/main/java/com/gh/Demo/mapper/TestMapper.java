package com.gh.Demo.mapper;

import com.gh.Demo.module.testModule;

import java.util.List;

public interface TestMapper {
    /**
     * 根据username查询用户
     */
    testModule selectByUsername(String username);
    /**
     * 添加用户
     */
    int addUser(testModule user);
    /**
     * 删除用户
     */
     void deleteByUsername(String username);
    /**
     * 修改信息
     */
    void updateUser(testModule user);
    /**
     * 查看所有人信息
     */
    List<testModule> selectAll();
}
