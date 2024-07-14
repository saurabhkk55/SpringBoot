package com.web.webApplication.department.controllers;

import com.web.webApplication.department.dto.DepartmentDTO;
import com.web.webApplication.department.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/dept")
public class DepartmentController {
    @Autowired
    private DepartmentService deptSvc;

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartment() {
        List<DepartmentDTO> get_all_departments = deptSvc.getAllDepartment();
        return new ResponseEntity<>(get_all_departments, HttpStatus.OK);
    }

    @GetMapping(path = "/{deptId}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long deptId) {
        DepartmentDTO get_department_by_Id = deptSvc.getDepartmentById(deptId);
        return new ResponseEntity<>(get_department_by_Id, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createNewDepartment(@RequestBody @Valid DepartmentDTO departmentDTO) {
        System.out.println("POST_MAPPING");
        DepartmentDTO saved_dept = deptSvc.createNewDepartment(departmentDTO);
        return new ResponseEntity<>(saved_dept, HttpStatus.OK);
    }

    @PutMapping(path = "/{deptId}")
    public ResponseEntity<DepartmentDTO> updateDepartmentById(@RequestBody @Valid DepartmentDTO departmentDTO, @PathVariable Long deptId) {
        DepartmentDTO update_department_by_id = deptSvc.updateDepartmentById(departmentDTO, deptId);
        return new ResponseEntity<>(update_department_by_id, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{deptId}")
    public ResponseEntity<Boolean> deletedepartmentById(@PathVariable Long deptId) {
        Boolean delete_department_by_id = deptSvc.deleteDepartmentById(deptId);
        if(delete_department_by_id) {
            return new ResponseEntity<>(delete_department_by_id, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(delete_department_by_id, HttpStatus.NOT_FOUND);
        }

    }
}
