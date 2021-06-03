package com.colocationbudget.colocationbudget.model;

import com.colocationbudget.colocationbudget.dto.UserColocationDto;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user_colocation")
public class UserColocation extends BaseModel{

    private Long id;
    private User user;
    private List<Colocation> colocations;

    public UserColocation() {
    }

    public UserColocationDto toDto() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, UserColocationDto.class);
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

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    public List<Colocation> getColocations() {
        return colocations;
    }

    public void setColocations(List<Colocation> colocations) {
        this.colocations = colocations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserColocation that = (UserColocation) o;
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
        return "UserColocation{" +
                "id=" + id +
                ", user=" + user +
                ", colocations=" + colocations +
                '}';
    }
}
