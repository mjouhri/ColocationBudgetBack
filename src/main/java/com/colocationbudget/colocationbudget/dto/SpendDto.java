package com.colocationbudget.colocationbudget.dto;

import com.colocationbudget.colocationbudget.model.Spend;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SpendDto extends BaseDto {
    private Long id;
    private TypeDto type;
    private Double amount;
    private String description;
    private String date;
    private String paymentMethod;
    private Boolean recurrent;
    private UserDto userPaye;
    private String image;

    public SpendDto() {
    }

    public Spend toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, Spend.class);
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
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
        SpendDto that = (SpendDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(type, that.type) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(description, that.description) &&
                Objects.equals(date, that.date) &&
                Objects.equals(paymentMethod, that.paymentMethod) &&
                Objects.equals(recurrent, that.recurrent) &&
                Objects.equals(userPaye, that.userPaye) &&
                Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, amount, description, date, paymentMethod, recurrent, userPaye, image);
    }

    @Override
    public String toString() {
        return "ExpenseDto{" +
                "id=" + id +
                ", type=" + type +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", recurrent=" + recurrent +
                ", userPaye=" + userPaye +
                ", image='" + image + '\'' +
                '}';
    }
}
