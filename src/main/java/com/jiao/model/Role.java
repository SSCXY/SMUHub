package com.jiao.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class Role {
    private Integer id;
    private String name;
    private String code;

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null) return false;
        if (!(object instanceof Role)) return false;
        Role other = (Role)object;
        if(id != other.id) return false;

        return true;
    }
}
