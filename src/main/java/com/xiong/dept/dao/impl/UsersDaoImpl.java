package com.xiong.dept.dao.impl;

import com.xiong.dept.dao.UsersDAO;
import com.xiong.dept.db.DBConn;
import com.xiong.dept.po.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDaoImpl implements UsersDAO {


    private Connection conn;
    private ResultSet rs;
    private PreparedStatement pst;

    DBConn db= DBConn.getInstance();

    @Override
    public boolean login(User user) throws SQLException {
        conn = db.getConn();
        boolean loginSucc=false;
        String sql = "select * from users where username=? and  password=? and type=? and age=?" ;
        pst = conn.prepareStatement(sql);
        pst.setString(1,user.getUsername());
        pst.setString(2,user.getPassword());
        pst.setString(3,user.getType());
        pst.setInt(4,user.getAge());
        rs = pst.executeQuery();
        if(rs.next()){
            loginSucc = true;
        }
        db.connClose();
        return loginSucc;
    }



}
