package com.xiong.dept.dao.impl;

import com.xiong.dept.dao.EmpDAO;
import com.xiong.dept.db.DBConn;
import com.xiong.dept.po.Dept;
import com.xiong.dept.po.Emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public  class EmpDAOImpl implements EmpDAO {
     private Connection conn;
     private ResultSet rs;
     private PreparedStatement pst;
     
     DBConn db= DBConn.getInstance();

	public int saveEmp(Emp emp) {
		int num=0;
		
		conn=db.getConn();
		
		String sql="insert into emp(name,sal,age,dept_id) values (?,?,?,?)";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,emp.getName());
			pst.setDouble(2, emp.getSal());
			pst.setInt(3, emp.getAge());
			pst.setInt(4, emp.getDeptId());

			num = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.connClose();
		return num;
	}

	@Override
	public List<Emp> getAllEmp() {
		conn=db.getConn();
		List<Emp> empList=null;
		String sql="select a.id,a.name,a.sal,a.age,a.dept_id,b.name dept_name,b.describ  from emp a,dept b where a.dept_id = b.id ";
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			empList=new ArrayList<Emp>();

			while(rs.next()){
				Emp emp=new Emp();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSal(rs.getDouble("sal"));
				emp.setAge(rs.getInt("age"));
				emp.setDeptId(rs.getInt("dept_id"));

				Dept d = new Dept();
				d.setName(rs.getString("dept_name"));
				d.setDesc(rs.getString("describ"));

				emp.setDept(d);

				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(empList);
		db.connClose();
		return empList;
	}


}

	
     
     
     

