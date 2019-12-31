package com.maike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.maike.model.User;
import com.maike.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {
    Connection con = null;
    PreparedStatement pt = null;
    ResultSet rs = null;
    String sql;
    User user = new User();
    @Override
    public int insert(String userName, String userPwd,String userIdentity) {
        // TODO Auto-generated method stub
        int k = 1;
        sql = "insert into user_list value(?,?,?)";
        try {
            con = ConnectionUtil.getConnection();
            pt = con.prepareStatement(sql);
            pt.setString(1, userName);
            pt.setString(2, userPwd);
            pt.setString(3, userIdentity);
            k = pt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            ConnectionUtil.closeRe(con, pt);
        }
        return k;
    }
    @Override
    public User selectByName(String userName) {
        // TODO Auto-generated method stub
        sql = "select * from user_list where id = ?";
        
        try {
            con = ConnectionUtil.getConnection();
            pt = con.prepareStatement(sql);
            pt.setString(1, userName);
            rs = pt.executeQuery();
            while(rs.next()) {
                user.setUserName(rs.getString("id"));
                user.setUserPwd(rs.getString("password"));
                user.setUserIdentity(rs.getString("identity"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            ConnectionUtil.closeRe(con, pt, rs);
        }
        return user;
    }
}
