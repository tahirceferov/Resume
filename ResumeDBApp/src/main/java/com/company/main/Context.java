package com.company.main;

import com.company.dao.UserDaoImpl;
import com.company.dao.UserDaoInter;

public class Context {
    public static UserDaoInter instanceUserDao(){
        return  new UserDaoImpl();
    }
}
