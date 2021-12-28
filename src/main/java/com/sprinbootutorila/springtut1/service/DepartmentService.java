package com.sprinbootutorila.springtut1.service;

import com.sprinbootutorila.springtut1.entity.Department;
import com.sprinbootutorila.springtut1.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

   public  List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(long departmentId) throws DepartmentNotFoundException;

   public  void deleteDepartmentById(long departmentId);

   public  Department updateDepartment(Long departmentId, Department department);

    public Department fetchByDepartName(String departmentName);
}
