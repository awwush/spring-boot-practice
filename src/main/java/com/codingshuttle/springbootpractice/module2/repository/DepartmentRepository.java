package com.codingshuttle.springbootpractice.module2.repository;

import com.codingshuttle.springbootpractice.module2.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
}
