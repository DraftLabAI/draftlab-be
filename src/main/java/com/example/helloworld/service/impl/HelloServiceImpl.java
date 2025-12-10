package com.example.helloworld.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.helloworld.dao.HelloDAO;
import com.example.helloworld.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private HelloDAO helloDAO;

    @Override
    public String getHello() {
        return helloDAO.getHello();
    }
}
