package com.company.dao;

import com.company.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl extends AbstractDao implements UserDaoInter {
    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
       try( Connection c = connect();){

        Statement stmt = c.createStatement();
        stmt.execute("select * from user");
        ResultSet rs = stmt.getResultSet();
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String email = rs.getString("email");
            String phone = rs.getString("phone");

            result.add(new User(id,name,surname,email,phone));

        }
       }
       catch (Exception ex){
         ex.printStackTrace();
       }
            return result;
    }



    @Override
    public boolean updateUser(User user) {
    try( Connection c = connect()){

    PreparedStatement stmt = c.prepareStatement("update user set name=?,surname=?,email=?,phone=? where id=?");
    stmt.setString(1, user.getName());
        stmt.setString(2, user.getSurname());
        stmt.setString(3, user.getEmail());
        stmt.setString(4, user.getPhone());
    stmt.setInt(5,user.getId());
    return stmt.execute();
    }
    catch (Exception ex){
       ex.printStackTrace();
       return false;
    }
    
    }

    @Override
    public boolean removeUser(int id) {
        try( Connection c = connect();){

            Statement stmt = c.createStatement();
            return stmt.execute("delete from user where id=" + id); }
        catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public User getById(int userId) {
        User result = null;
        try (Connection c = connect()) {

            Statement stmt = c.createStatement();
            stmt.execute("select * from user where id=" + userId);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

                result = new User(id, name, surname, email, phone);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }


}
