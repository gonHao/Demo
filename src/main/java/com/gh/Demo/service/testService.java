package com.gh.Demo.service;

import com.gh.Demo.mapper.TestMapper;
import com.gh.Demo.module.testModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class testService {
    @Autowired
    private TestMapper iTestMapper;
    public testModule browseUser(String username){
        return iTestMapper.selectByUsername(username);
    }
    public int addUser(testModule user){
        return iTestMapper.addUser(user);
    }
    public void dorpUser(String username){
       iTestMapper.deleteByUsername(username);
    }
    public void updateUser(testModule user){
        iTestMapper.updateUser(user);
    }
    public List<testModule> findAll(){
        return iTestMapper.selectAll();
    }
}
