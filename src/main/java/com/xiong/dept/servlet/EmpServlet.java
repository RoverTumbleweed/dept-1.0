package com.xiong.dept.servlet;

import com.xiong.dept.dao.DeptDAO;
import com.xiong.dept.dao.EmpDAO;
import com.xiong.dept.factory.DeptFactory;
import com.xiong.dept.factory.EmpFactory;
import com.xiong.dept.po.Dept;
import com.xiong.dept.po.Emp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EmpServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String method = request.getParameter("method");

		System.out.println(method);

		String path = null;
		if (method.equals("add")) {

			DeptDAO deptDao=DeptFactory.getInstance();
			List<Dept> deptList = deptDao.getAllDept();

			request.setAttribute("deptList", deptList);

			path = "emp/createEmployee.jsp";

		} else if (method.equals("save")) {

			String ename=request.getParameter("name");
			String sal=request.getParameter("salary");
			String age=request.getParameter("age");
			int deptno=Integer.parseInt(request.getParameter("deptId"));


			Emp emp=new Emp();
			emp.setDeptId(deptno);
			emp.setName(ename);
			emp.setSal(Double.parseDouble(sal));
			emp.setAge(Integer.parseInt(age));

			EmpDAO empDao = EmpFactory.getInstance();
			empDao.saveEmp(emp);


			List<Emp> empList = empDao.getAllEmp();

			request.setAttribute("empList", empList);
			path = "emp/viewAllEmployee.jsp";

		} else if (method.equals("selectAll")) {
			EmpDAO empDao = EmpFactory.getInstance();
			List<Emp> empList = empDao.getAllEmp();

			request.setAttribute("empList", empList);
			path = "emp/viewAllEmployee.jsp";
		}

		request.getRequestDispatcher(path).forward(request, response);

			
	}
}
