package com.ss.ucm.ms.loans.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;



@Entity
@Table(name = "loan")
public class Loan implements Serializable {
    private static final long serialVersionUID = 7246464097788438489L;

    //Data
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "max_amount")
    private BigDecimal maxAmount;

    @Column(name = "name")
    private String name;

    @Column(name = "interest_rate")
    private BigDecimal interestRate;
    

    //Methods
    /**
     * Public no-arg constructor
     */
    public Loan() {
    }

    /**
     * @author Joshua Podhola
     * @param maxAmount Max amount for loan
     * @param name Name of loan
     * @param interestRate Interest rate of loan
     */
    public Loan(BigDecimal maxAmount, String name, BigDecimal interestRate) {
        this.maxAmount = maxAmount;
        this.name = name;
        this.interestRate = interestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return Objects.equals(id, loan.id) && Objects.equals(maxAmount, loan.maxAmount) && Objects.equals(name, loan.name) && Objects.equals(interestRate, loan.interestRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, maxAmount, name, interestRate);
    }
}
