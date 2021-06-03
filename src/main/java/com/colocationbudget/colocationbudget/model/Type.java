package com.colocationbudget.colocationbudget.model;


import com.colocationbudget.colocationbudget.dto.TypeDto;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "type")
public class Type extends BaseModel{

    private Long id;
    private String path;
    private String color;
    private String name;

    public Type() {
    }

    public TypeDto toDto() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, TypeDto.class);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return Objects.equals(id, type.id) &&
                Objects.equals(path, type.path) &&
                Objects.equals(color, type.color) &&
                Objects.equals(name, type.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, path, color, name);
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", color='" + color + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
