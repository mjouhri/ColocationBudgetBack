package com.colocationbudget.colocationbudget.model;

import com.colocationbudget.colocationbudget.dto.ExpenseDto;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "expense")
public class Expense extends BaseModel{

    private Long id;
    private Type type;
    private Double value;
    private String description;
    private LocalDate date;
    private String payementMethod;
    private Boolean recurrent;
    private User userPaye;
    private String image;

    public Expense() {
    }

    public ExpenseDto toDto() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, ExpenseDto.class);
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

    @Column(name = "value")
    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
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

    @Column(name = "payement_method")
    public String getPayementMethod() {
        return payementMethod;
    }

    public void setPayementMethod(String payementMethod) {
        this.payementMethod = payementMethod;
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
        Expense expense = (Expense) o;
        return Objects.equals(id, expense.id) &&
                Objects.equals(type, expense.type) &&
                Objects.equals(value, expense.value) &&
                Objects.equals(description, expense.description) &&
                Objects.equals(date, expense.date) &&
                Objects.equals(payementMethod, expense.payementMethod) &&
                Objects.equals(recurrent, expense.recurrent) &&
                Objects.equals(userPaye, expense.userPaye) &&
                Objects.equals(image, expense.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, value, description, date, payementMethod, recurrent, userPaye, image);
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", type=" + type +
                ", value=" + value +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", payementMethod='" + payementMethod + '\'' +
                ", recurrent=" + recurrent +
                ", userPaye=" + userPaye +
                ", image='" + image + '\'' +
                '}';
    }
}
