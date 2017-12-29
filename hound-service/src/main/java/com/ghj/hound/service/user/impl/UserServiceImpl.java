package com.ghj.hound.service.user.impl;

import com.ghj.hound.entity.demo.Demo;
import com.ghj.hound.mapper.DemoMapper;
import com.ghj.hound.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public List<Demo> getUser() {
        return demoMapper.getNameDemo();
    }
}