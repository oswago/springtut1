package com.sprinbootutorila.springtut1.service;

import com.sprinbootutorila.springtut1.entity.Department;
import com.sprinbootutorila.springtut1.error.DepartmentNotFoundException;
import com.sprinbootutorila.springtut1.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    DepartmentService departmentService;
    @MockBean
    DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department=Department.builder()
                 .departmentName("IT")
                 .departmentCode("IT006")
                 .departmentAddress("KISUMU 100")
                 .departmentId(1L)
                 .build();
        Mockito.when(departmentRepository.findByDepartmentName("IT"))
                .thenReturn(department);

        Mockito.when(departmentRepository.getById(1l))
                .thenReturn(department);
    }
    @Test
    @DisplayName("Get Data on Valid Department Name")
    public void whenvalidDepartment_then_DepartmentFound(){
      String departmentName="IT";
      Department found=departmentService.fetchByDepartName(departmentName);
      assertEquals(departmentName,found.getDepartmentName());
    }
    @Test
    public void whenValidDepartmentId_then_DepartmentIdFound() throws DepartmentNotFoundException {
        long id=1;
        Department found=departmentService.fetchDepartmentById(id);
        assertEquals(id,found.getDepartmentId());

    }
}