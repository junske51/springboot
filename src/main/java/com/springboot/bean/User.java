package com.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private Integer age;
    private String email;
}
