package com.colocationbudget.colocationbudget.dto;

import com.colocationbudget.colocationbudget.model.User;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.Objects;

public class UserDto extends BaseDto {
    private Long id;
    private String email;
    private String password;
    private String lastConnexion;
    private String lastName;
    private String firstName;
    private String dateOfBirth;
    private String image;

    public UserDto() {
    }

    public User toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, User.class);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastConnexion() {
        return lastConnexion;
    }

    public void setLastConnexion(String lastConnexion) {
        this.lastConnexion = lastConnexion;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getDateOfBirth() {
        return getFormattedLocalDate(this.dateOfBirth);
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

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
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id) &&
                Objects.equals(email, userDto.email) &&
                Objects.equals(password, userDto.password) &&
                Objects.equals(lastConnexion, userDto.lastConnexion) &&
                Objects.equals(lastName, userDto.lastName) &&
                Objects.equals(firstName, userDto.firstName) &&
                Objects.equals(dateOfBirth, userDto.dateOfBirth) &&
                Objects.equals(image, userDto.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, lastConnexion, lastName, firstName, dateOfBirth, image);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", lastConnexion='" + lastConnexion + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
