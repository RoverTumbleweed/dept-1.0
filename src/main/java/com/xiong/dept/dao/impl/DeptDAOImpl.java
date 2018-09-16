package com.xiong.dept.dao.impl;


import com.xiong.dept.dao.DeptDAO;
import com.xiong.dept.db.DBConn;
import com.xiong.dept.po.Dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDAOImpl implements DeptDAO {

     private Connection conn;
     private ResultSet rs;
     private PreparedStatement pst;
     
     DBConn db= DBConn.getInstance();

     public List<Dept> getAllDept() {
    		
 		conn=db.getConn();
 		List<Dept> deptList=null;
 		String sql="select id,name,describ from dept ";
 		try {
 			pst=conn.prepareStatement(sql);
 			rs=pst.executeQuery();

 			deptList = new ArrayList<Dept>();
 			
 			while(rs.next()){
 				Dept dept = new Dept();
 				
 				dept.setId(rs.getInt("id"));
 				dept.setName(rs.getString("name"));
 				dept.setDesc(rs.getString("describ"));
 				deptList.add(dept);
 			}
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 		db.connClose();
 		return deptList;
 	}

	@Override
	public int saveDept(Dept dept) {
		return 0;
	}

	@Override
	public List<Dept> getDeptLeader() {
		return null;
	}

	@Override
	public List<Dept> getAllDeptLeader() {
		return null;
	}

}