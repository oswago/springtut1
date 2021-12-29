package com.sprinbootutorila.springtut1.controller;

import com.sprinbootutorila.springtut1.entity.Department;
import com.sprinbootutorila.springtut1.error.DepartmentNotFoundException;
import com.sprinbootutorila.springtut1.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    DepartmentService departmentService;


    Department department;
    @BeforeEach
    void setUp() {
        department=Department.builder()
                .departmentCode("IT123")
                .departmentName("IT")
                .departmentAddress("Kisumu100")
                .departmentId(1l)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {

        Department departmentInput=Department.builder()
                .departmentCode("IT123")
                .departmentName("IT")
                .departmentAddress("Kisumu100")
                .build();
        Mockito.when(departmentService.saveDepartment(departmentInput))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/department")
                .contentType(MediaType.APPLICATION_JSON)
                .content("       {\"departmentName\":\"IT\",\n" +
                        "                \"departmentAddress\":\"Kisumu100\",\n" +
                        "                \"departmentCode \":\"IT123\"\n" +
                        "                    }"
                )).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.departmentName")
                        .value(department.getDepartmentName()));
    }
}