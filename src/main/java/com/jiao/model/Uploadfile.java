package com.jiao.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter@Setter@ToString
public class Uploadfile {
    private Integer id;
    private String creator;
    private String filename;
    private String path;
    private Date addDate;

    public Uploadfile(){

    }

    public Uploadfile(String creator, String filename, String path, Date addDate) {
        this.creator = creator;
        this.filename = filename;
        this.path = path;
        this.addDate = addDate;
    }
}
