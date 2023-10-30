package com.company.main;



import com.company.dao.UserDaoInter;




public class Main {



    public static void main(String[] args) throws Exception {

        UserDaoInter userDao = Context.instanceUserDao();
        System.out.println(userDao.getAll());


        
    }
}