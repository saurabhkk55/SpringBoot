package com.web.webApplication.department.services;

import com.web.webApplication.department.dto.DepartmentDTO;
import com.web.webApplication.department.entities.DepartmentEntity;
import com.web.webApplication.department.exceptions.DepartmentException;
import com.web.webApplication.department.repositories.DepartmentRepository;
import employee.exceptions.SaurabhException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository deptRepo;

    private final ModelMapper modelMapper;

    public DepartmentService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<DepartmentDTO> getAllDepartment() {
        List<DepartmentEntity> departmentEntities = deptRepo.findAll();
        return departmentEntities
                    .stream()
                    .map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class))
                    .collect(Collectors.toList());
    }

    public DepartmentDTO getDepartmentById(Long deptId) {
        Optional<DepartmentEntity> optional_department_entity = deptRepo.findById(deptId);
//        DepartmentEntity department_entity = optional_department_entity.orElseThrow();
        DepartmentEntity department_entity = optional_department_entity.orElseThrow(() -> new DepartmentException("Department with " + deptId + " id does not exist"));
        return modelMapper.map(department_entity, DepartmentDTO.class); // Unreachable statement if exception occurs in the above line
    }

    public DepartmentDTO createNewDepartment(DepartmentDTO departmentDTO) {
        DepartmentEntity toSaveEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        DepartmentEntity savedEntity = deptRepo.save(toSaveEntity);
        return modelMapper.map(savedEntity, DepartmentDTO.class);
    }

    public DepartmentDTO updateDepartmentById(DepartmentDTO departmentDTO, Long deptId) {
        DepartmentEntity toSaveEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        toSaveEntity = deptRepo.save(toSaveEntity);
        return modelMapper.map(toSaveEntity, DepartmentDTO.class);
    }

    public Boolean deleteDepartmentById(Long deptId) {
        Optional<DepartmentEntity> deprartment_entity = deptRepo.findById(deptId);
        if(deprartment_entity.isPresent()) {
            deptRepo.deleteById(deptId);
            return true;
        }
        return false;
    }
}
