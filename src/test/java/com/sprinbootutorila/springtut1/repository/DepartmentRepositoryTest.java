package com.sprinbootutorila.springtut1.repository;

import com.sprinbootutorila.springtut1.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach

    void setUp() {
        Department department=
                Department.builder()
                        .departmentAddress("Bangkok")
                        .departmentId(1L)
                        .departmentCode("QT123")
                        .departmentName("Mechanical eng")
                        .build();
        testEntityManager.merge(department);


    }

     @Test
    public void whenFindDepartmentById_thenValidDepartmentName(){
        Department department=departmentRepository.getById(1L);
        assertEquals(department.getDepartmentName(),"Mechanical eng");
    }

}