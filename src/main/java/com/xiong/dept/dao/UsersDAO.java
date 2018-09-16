package com.xiong.dept.dao;

import com.xiong.dept.po.User;

import java.sql.SQLException;

public interface UsersDAO {

	public boolean login(User user) throws SQLException;
   
}
