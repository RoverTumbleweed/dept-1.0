package com.xiong.dept.factory;


import com.xiong.dept.dao.DeptDAO;
import com.xiong.dept.dao.impl.DeptDAOImpl;

public class DeptFactory {
    public static DeptDAO getInstance(){
    
    	return new DeptDAOImpl();
    }
}
