package com.xiong.dept.dao;


import com.xiong.dept.po.Dept;

import java.util.List;

public interface DeptDAO {

    public List<Dept> getAllDept();
    
    public  int saveDept(Dept dept);

    public List<Dept> getDeptLeader();
    
    public List<Dept> getAllDeptLeader();
}
