package com.company;


import com.company.bean.User;
import com.company.dao.UserDaoImpl;
import com.company.dao.UserDaoInter;


import java.util.List;

public class Main {



    public static void main(String[] args) throws Exception {

        UserDaoInter userDao = new UserDaoImpl();
        List<User> userList = userDao.getAll();
        System.out.println("userList : " + userList);
        userDao.removeUser(2);
        List<User> userList1 = userDao.getAll();
        System.out.println("userList1 : " + userList1);

        User user = userDao.getById(1);
        user.setSurname("Celalova");
        userDao.updateUser(user);
        
    }
}