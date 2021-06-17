package com.colocationbudget.colocationbudget.dto;


import com.colocationbudget.colocationbudget.model.UserColocation;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserColocationDto extends BaseDto{

    private Long id;
    private UserDto user;
    private List<ColocationDto> colocations;

    public UserColocationDto() {
    }

    public UserColocation toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, UserColocation.class);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public List<ColocationDto> getColocations() {
        return colocations;
    }

    public void setColocations(List<ColocationDto> colocations) {
        this.colocations = colocations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserColocationDto that = (UserColocationDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(user, that.user) &&
                Objects.equals(colocations, that.colocations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, colocations);
    }

    @Override
    public String toString() {
        return "UserColocationDto{" +
                "id=" + id +
                ", user=" + user +
                ", colocations=" + colocations +
                '}';
    }
}
