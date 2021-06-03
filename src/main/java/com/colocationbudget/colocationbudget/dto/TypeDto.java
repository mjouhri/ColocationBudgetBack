package com.colocationbudget.colocationbudget.dto;

import com.colocationbudget.colocationbudget.model.Type;
import org.modelmapper.ModelMapper;

import java.util.Objects;

public class TypeDto extends BaseDto{

    private Long id;
    private String path;
    private String color;
    private String name;

    public TypeDto() {
    }

    public Type toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, Type.class);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

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
        TypeDto typeDto = (TypeDto) o;
        return Objects.equals(id, typeDto.id) &&
                Objects.equals(path, typeDto.path) &&
                Objects.equals(color, typeDto.color) &&
                Objects.equals(name, typeDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, path, color, name);
    }

    @Override
    public String toString() {
        return "TypeDto{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", color='" + color + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
