package com.sprinbootutorila.springtut1.controller;

import com.sprinbootutorila.springtut1.entity.Department;
import com.sprinbootutorila.springtut1.service.DepartmentService;
import com.sprinbootutorila.springtut1.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.soap.Addressing;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/department")
     public Department saveDepartment(@RequestBody Department department){
       // DepartmentService service=new DepartmentServiceImpl();
        return departmentService.saveDepartment(department);
      }
      @GetMapping("/departments")
      public List<Department> fetchDepartmentList(){
       return departmentService.fetchDepartmentList();
      }
      @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") long departmentId){
       return departmentService.fetchDepartmentById(departmentId);
    }
     @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department Deleted Successfully!";
    }
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);

    }
    @GetMapping("/departments/name/{name}")
    public Department fetchByDepartName(@PathVariable("name") String departmentName){
          return departmentService.fetchByDepartName(departmentName);
    }





}
