package com.colocationbudget.colocationbudget.dto;

import com.colocationbudget.colocationbudget.model.Colocation;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ColocationDto extends BaseDto {

    private Long id;
    private String name;
    private UserDto owner;
    private List<UserDto> users;
    private List<SpendDto> spends;

    public Colocation toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, Colocation.class);
    }

    public ColocationDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDto getOwner() {
        return owner;
    }

    public void setOwner(UserDto owner) {
        this.owner = owner;
    }

    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }

    public List<SpendDto> getSpends() {
        return spends;
    }

    public void setSpends(List<SpendDto> spends) {
        this.spends = spends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColocationDto that = (ColocationDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(owner, that.owner) &&
                Objects.equals(users, that.users) &&
                Objects.equals(spends, that.spends);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, owner, users, spends);
    }

    @Override
    public String toString() {
        return "ColocationDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", users=" + users +
                ", spends=" + spends +
                '}';
    }
}
