package com.jiao.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class Resource {
    private Integer id;
    private String path;

    public Resource(String path) {
        this.path = path;
    }

    public Resource() {
    }
}
