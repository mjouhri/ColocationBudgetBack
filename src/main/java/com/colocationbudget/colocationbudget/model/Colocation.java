package com.colocationbudget.colocationbudget.model;

import com.colocationbudget.colocationbudget.dto.ColocationDto;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "colocation")
public class Colocation extends BaseModel{

    private Long id;
    private String name;
    private User owner;
    private List<User> users;
    private List<Expense> expenses;

    public Colocation() {
    }

    public ColocationDto toDto() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, ColocationDto.class);
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

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colocation that = (Colocation) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(owner, that.owner) &&
                Objects.equals(users, that.users) &&
                Objects.equals(expenses, that.expenses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, owner, users, expenses);
    }

    @Override
    public String toString() {
        return "Colocation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", users=" + users +
                ", expenses=" + expenses +
                '}';
    }
}
