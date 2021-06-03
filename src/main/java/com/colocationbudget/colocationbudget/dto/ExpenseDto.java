package com.colocationbudget.colocationbudget.dto;

import com.colocationbudget.colocationbudget.model.Expense;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExpenseDto extends BaseDto {
    private Long id;
    private TypeDto type;
    private Double value;
    private String description;
    private String date;
    private String payementMethod;
    private Boolean recurrent;
    private UserDto userPaye;
    private String image;

    public ExpenseDto() {
    }

    public Expense toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, Expense.class);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeDto getType() {
        return type;
    }

    public void setType(TypeDto type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return getFormattedLocalDate(this.date);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPayementMethod() {
        return payementMethod;
    }

    public void setPayementMethod(String payementMethod) {
        this.payementMethod = payementMethod;
    }

    public Boolean getRecurrent() {
        return recurrent;
    }

    public void setRecurrent(Boolean recurrent) {
        this.recurrent = recurrent;
    }

    public UserDto getUserPaye() {
        return userPaye;
    }

    public void setUserPaye(UserDto userPaye) {
        this.userPaye = userPaye;
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
        ExpenseDto that = (ExpenseDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(type, that.type) &&
                Objects.equals(value, that.value) &&
                Objects.equals(description, that.description) &&
                Objects.equals(date, that.date) &&
                Objects.equals(payementMethod, that.payementMethod) &&
                Objects.equals(recurrent, that.recurrent) &&
                Objects.equals(userPaye, that.userPaye) &&
                Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, value, description, date, payementMethod, recurrent, userPaye, image);
    }

    @Override
    public String toString() {
        return "ExpenseDto{" +
                "id=" + id +
                ", type=" + type +
                ", value=" + value +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", payementMethod='" + payementMethod + '\'' +
                ", recurrent=" + recurrent +
                ", userPaye=" + userPaye +
                ", image='" + image + '\'' +
                '}';
    }
}
