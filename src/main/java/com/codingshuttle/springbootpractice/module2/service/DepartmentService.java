package com.codingshuttle.springbootpractice.module2.service;

import com.codingshuttle.springbootpractice.module2.dto.DepartmentDTO;
import com.codingshuttle.springbootpractice.module2.entities.DepartmentEntity;
import com.codingshuttle.springbootpractice.module2.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class DepartmentService {


    private final ModelMapper modelMapper;
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.departmentRepository = departmentRepository;
    }

    public DepartmentDTO getDepartmentBId(Long departmentId) {
        DepartmentEntity departmentEntity = departmentRepository.findById(departmentId).orElse(null);
        return modelMapper.map(departmentEntity, DepartmentDTO.class);
    }

    public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
        List<DepartmentDTO> departmentDTOs = departmentEntities
                .stream()
                .map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class)).collect(Collectors.toList());
        return departmentDTOs;
    }

    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        DepartmentEntity toSaveDepartmentEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        DepartmentEntity departmentEntity = departmentRepository.save(toSaveDepartmentEntity);
        return modelMapper.map(departmentEntity, DepartmentDTO.class);
    }

    public DepartmentDTO updateDepartment(DepartmentDTO departmentDTO, Long departmentId) {
        DepartmentEntity toSaveDepartmentEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        toSaveDepartmentEntity.setId(departmentId);
        DepartmentEntity departmentEntity = departmentRepository.save(toSaveDepartmentEntity);
        return modelMapper.map(departmentEntity, DepartmentDTO.class);
    }

    public DepartmentDTO updatePartialDepartmentById(Map<String, Object> updates, Long departmentId) {
        boolean exists = departmentRepository.existsById(departmentId);
        if (!exists) return null;
        DepartmentEntity departmentEntity = departmentRepository.findById(departmentId).get();
        updates.forEach((key, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.getRequiredField(DepartmentEntity.class, key);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, departmentEntity, value);
        });
        departmentRepository.save(departmentEntity);
        return null;
    }

    public boolean deleteDepartmentById(Long departmentId) {
        boolean exists = isExistsByDepartmentId(departmentId);
        if (!exists) return false;
        departmentRepository.deleteById(departmentId);
        return true;
    }

    public boolean isExistsByDepartmentId(Long departmentId) {
        return departmentRepository.existsById(departmentId);
    }
}
