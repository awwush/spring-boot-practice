package com.codingshuttle.springbootpractice.module2.controllers;

import com.codingshuttle.springbootpractice.module2.dto.DepartmentDTO;
import com.codingshuttle.springbootpractice.module2.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/{departmentId}")
    public DepartmentDTO getDepartmentBId(@PathVariable Long departmentId) {
        return departmentService.getDepartmentBId(departmentId);
    }

    @GetMapping
    public List<DepartmentDTO> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping
    public DepartmentDTO createDepartment(@RequestBody @Valid DepartmentDTO departmentDTO) {
        return departmentService.createDepartment(departmentDTO);
    }

    @PutMapping(path = "/{departmentId}")
    public DepartmentDTO updateDepartment(@RequestBody DepartmentDTO departmentDTO, @PathVariable Long departmentId) {
        return departmentService.updateDepartment(departmentDTO, departmentId);
    }

    @PatchMapping(path = "/{departmentId}")
    public DepartmentDTO updatePartialDepartmentById(@RequestBody Map<String, Object> updates, @PathVariable Long departmentId) {
        return departmentService.updatePartialDepartmentById(updates, departmentId);
    }

    @DeleteMapping(path = "/{departmentId}")
    public boolean deleteDepartmentById(@PathVariable Long departmentId) {
        return departmentService.deleteDepartmentById(departmentId);
    }

}
