package com.sprinbootutorila.springtut1.service;

import com.sprinbootutorila.springtut1.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

   public  List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(long departmentId);

   public  void deleteDepartmentById(long departmentId);

   public  Department updateDepartment(Long departmentId, Department department);

    public Department fetchByDepartName(String departmentName);
}
