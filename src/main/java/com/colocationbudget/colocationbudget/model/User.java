package com.colocationbudget.colocationbudget.model;

import com.colocationbudget.colocationbudget.dto.UserDto;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User extends BaseModel{

    private Long id;
    private String email;
    private String password;
    private LocalDateTime lastConnexion;
    private String lastName;
    private String firstName;
    private LocalDate dateOfBirth;
    private String image;

    public User() {
    }

    public UserDto toDto() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, UserDto.class);
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

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    @Column(name = "password")
    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "last_connexion")
    public LocalDateTime getLastConnexion() {
        return lastConnexion;
    }

    public void setLastConnexion(LocalDateTime lastConnexion) {
        this.lastConnexion = lastConnexion;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "date_of_birth")
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(lastConnexion, user.lastConnexion) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(dateOfBirth, user.dateOfBirth) &&
                Objects.equals(image, user.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, lastConnexion, lastName, firstName, dateOfBirth, image);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", lastConnexion=" + lastConnexion +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", image='" + image + '\'' +
                '}';
    }
}
