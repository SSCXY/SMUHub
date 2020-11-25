package com.jiao.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter@Setter@ToString
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private Integer enable;
    private Date addDate;
    private List<Role> roles;

}
