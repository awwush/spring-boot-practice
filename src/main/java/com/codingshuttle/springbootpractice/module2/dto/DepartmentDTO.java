package com.codingshuttle.springbootpractice.module2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private Long id;

    private String title;

    private Boolean isActive;

    private LocalDate createdAt;
}
