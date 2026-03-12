package com.library.dao;

import com.library.model.*;

import java.sql.*;

public class UserDAO {

    public User login(String email,String password){

        User user=null;

        try{

            Connection con=DBConnection.getConnection();

            String sql="SELECT * FROM users WHERE email=? AND password=?";

            PreparedStatement ps=con.prepareStatement(sql);

            ps.setString(1,email);
            ps.setString(2,password);

            ResultSet rs=ps.executeQuery();

            if(rs.next()){

                user=new User();

                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setRole(rs.getString("role"));

            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return user;
    }

    public void changeRole(int id,String role){

        try{

            Connection con=DBConnection.getConnection();

            String sql="UPDATE users SET role=? WHERE id=?";

            PreparedStatement ps=con.prepareStatement(sql);

            ps.setString(1,role);
            ps.setInt(2,id);

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}