package com.xiong.dept.factory;


import com.xiong.dept.dao.EmpDAO;
import com.xiong.dept.dao.impl.EmpDAOImpl;

public class EmpFactory {
    public static EmpDAO getInstance(){
    	return new EmpDAOImpl();
    }
}
