package com.springboot.bean;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
@ToString
@Data
public class Monster {
    private Integer id;
    private String name;
    private Integer age;
    private Boolean isMarried;
    private Date birth;
    private Car car;
}
