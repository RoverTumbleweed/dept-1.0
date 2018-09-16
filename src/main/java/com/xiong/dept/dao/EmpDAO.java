package com.xiong.dept.dao;


import com.xiong.dept.po.Emp;

import java.util.List;

public interface EmpDAO {

   public  int saveEmp(Emp emp);

   public List<Emp> getAllEmp();

}
