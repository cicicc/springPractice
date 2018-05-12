package com.afeng.dao.impl;

import com.afeng.dao.UserDao;
import org.springframework.stereotype.Component;

@Component(value = "userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void sayHello() {
        System.out.println("Hello Spring");
    }
}
