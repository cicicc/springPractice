package com.afeng.dao.impl;

import com.afeng.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void sayHello() {
        System.out.println("Hello Spring");
    }
}
