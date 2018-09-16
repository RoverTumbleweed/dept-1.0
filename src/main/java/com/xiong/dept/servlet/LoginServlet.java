package com.xiong.dept.servlet;


import com.xiong.dept.dao.UsersDAO;
import com.xiong.dept.factory.UsersFactory;
import com.xiong.dept.po.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	  	String username=request.getParameter("username").trim();
  		String password=request.getParameter("pwd").trim();
  		String type=request.getParameter("ty").trim();
  		String age=request.getParameter("age").trim();

		System.out.println("username:" + username);
		System.out.println("password:" + password);
        System.out.println("type" + type);
        System.out.println("age" + age);

		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setType(type);
        int a = Integer.parseInt(age);
		user.setAge(a);

		String path = null;

		UsersDAO usersDAO = UsersFactory.getIstance();
		try {
			boolean flag = usersDAO.login(user);
			if (flag) {
				request.setAttribute("msg", "登录成功 hello world");
				path = "index.jsp";
			} else {
				request.setAttribute("error", "用户名密码错误");
				path="login.jsp";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(path) .forward(request, response);
	}

}
