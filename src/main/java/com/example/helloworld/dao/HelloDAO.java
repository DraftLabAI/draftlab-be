package com.example.helloworld.dao;

import org.apache.ibatis.session.SqlSession;  // ★ MyBatis SqlSession
import org.springframework.stereotype.Repository;  // ★ Spring Bean 등록
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class HelloDAO {

    @Autowired
    private SqlSession sqlSession;

    public String getHello() {
        return sqlSession.selectOne("helloMapper.getHello");
    }
}
