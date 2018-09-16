package com.xiong.dept.factory;


import com.xiong.dept.dao.UsersDAO;
import com.xiong.dept.dao.impl.UsersDaoImpl;

public class UsersFactory {
    public static UsersDAO getIstance(){
    	return new UsersDaoImpl();
    }
}
