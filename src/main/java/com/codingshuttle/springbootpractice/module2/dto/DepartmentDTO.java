package com.codingshuttle.springbootpractice.module2.dto;

import com.codingshuttle.springbootpractice.module2.annotations.Password;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartmentDTO {
    private Long id;

    private String title;

    private Boolean isActive;

    private LocalDate createdAt;

    @Password
    private String password;

}
