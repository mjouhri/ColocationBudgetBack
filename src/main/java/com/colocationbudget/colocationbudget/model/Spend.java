package com.colocationbudget.colocationbudget.model;

import com.colocationbudget.colocationbudget.dto.SpendDto;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "spend")
public class Spend extends BaseModel{

    private Long id;
    private Type type;
    private Double amount;
    private String description;
    private LocalDate date;
    private String paymentMethod;
    private Boolean recurrent;
    private User userPaye;
    private String image;

    public Spend() {
    }

    public SpendDto toDto() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, SpendDto.class);
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
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Column(name = "amount")
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "date")
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Column(name = "payment_method")
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Column(name = "recurrent")
    public Boolean getRecurrent() {
        return recurrent;
    }

    public void setRecurrent(Boolean recurrent) {
        this.recurrent = recurrent;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    public User getUserPaye() {
        return userPaye;
    }

    public void setUserPaye(User userPaye) {
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
        Spend spend = (Spend) o;
        return Objects.equals(id, spend.id) &&
                Objects.equals(type, spend.type) &&
                Objects.equals(amount, spend.amount) &&
                Objects.equals(description, spend.description) &&
                Objects.equals(date, spend.date) &&
                Objects.equals(paymentMethod, spend.paymentMethod) &&
                Objects.equals(recurrent, spend.recurrent) &&
                Objects.equals(userPaye, spend.userPaye) &&
                Objects.equals(image, spend.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, amount, description, date, paymentMethod, recurrent, userPaye, image);
    }

    @Override
    public String toString() {
        return "Spend{" +
                "id=" + id +
                ", type=" + type +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", recurrent=" + recurrent +
                ", userPaye=" + userPaye +
                ", image='" + image + '\'' +
                '}';
    }
}
