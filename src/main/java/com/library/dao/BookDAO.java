package com.library.dao;

import com.library.model.*;

import java.sql.*;

public class BookDAO {

    public boolean canIssue(int userId){

        boolean allowed=true;

        try{

            Connection con=DBConnection.getConnection();

            String sql="SELECT * FROM issues WHERE user_id=?";

            PreparedStatement ps=con.prepareStatement(sql);

            ps.setInt(1,userId);

            ResultSet rs=ps.executeQuery();

            if(rs.next())
                allowed=false;

        }catch(Exception e){
            e.printStackTrace();
        }

        return allowed;
    }

    public void issueBook(int userId,int bookId){

        try{

            Connection con=DBConnection.getConnection();

            String sql="INSERT INTO issues(user_id,book_id) VALUES(?,?)";

            PreparedStatement ps=con.prepareStatement(sql);

            ps.setInt(1,userId);
            ps.setInt(2,bookId);

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}