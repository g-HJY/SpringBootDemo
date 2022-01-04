package com.example.demo.entity.test2;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.io.Serializable;

/**
 * (Salaries)实体类
 *
 * @author makejava
 * @since 2021-12-20 09:55:29
 */
@Getter
@Setter
public class Salaries implements Serializable {
    private static final long serialVersionUID = -95213502783840294L;
    
    private Integer id;
    
    private Integer empNo;
    
    private Integer salary;
    
    private Date fromDate;
    
    private Date toDate;

}

