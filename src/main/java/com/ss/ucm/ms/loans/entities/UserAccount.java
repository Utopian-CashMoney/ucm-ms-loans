package com.ss.ucm.ms.loans.entities;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;


@Entity
@Table(	name = "user_account")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "accountNumber")
public class UserAccount {
	
	@Id
	private String accountNumber;
	
	
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name="users_id")
    @JsonIgnore
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="account_id")
    @JsonManagedReference
    @JsonIgnore
    private AccountType account_type;
    
    
    @OneToMany(mappedBy="user_account", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
  //  @JsonBackReference
	private Set<UserLoan> userLoan;

    
    @Column(name="balance")
    BigDecimal balance;
    

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AccountType getAccount_type() {
		return account_type;
	}

	public void setAccount_type(AccountType account_type) {
		this.account_type = account_type;
	}
	
	

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Set<UserLoan> getUserLoan() {
		return userLoan;
	}

	public void setUserLoan(Set<UserLoan> userLoan) {
		this.userLoan = userLoan;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((account_type == null) ? 0 : account_type.hashCode());
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((userLoan == null) ? 0 : userLoan.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAccount other = (UserAccount) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (account_type == null) {
			if (other.account_type != null)
				return false;
		} else if (!account_type.equals(other.account_type))
			return false;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (userLoan == null) {
			if (other.userLoan != null)
				return false;
		} else if (!userLoan.equals(other.userLoan))
			return false;
		return true;
	}


	
    
    
    
	

}
