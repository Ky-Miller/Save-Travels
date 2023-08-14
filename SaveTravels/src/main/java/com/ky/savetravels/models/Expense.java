package com.ky.savetravels.models;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 1, max = 200, message="expense name must not be blank")
    private String expense;
    @NotNull
    @Size(min = 5, max = 200, message="Vendor must not be blank")
    private String vendor;
    @NotNull
    @Min(value=1, message="Please enter a value")
    private Integer amount;
    @NotNull
    @Size(min = 5, max = 200, message="Description must not be blank")
    private String description;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	public Expense(@NotNull @Size(min = 1, max = 200, message = "expense name must not be blank") String expense,
			@NotNull @Size(min = 5, max = 200, message = "Vendor must not be blank") String vendor,
			@NotNull @Min(value=1, message="Please enter a value") Integer amount,
			@NotNull @Size(min = 5, max = 200, message = "Description must not be blank") String description) {
		super();
		this.expense = expense;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}

	public Expense() {
		super();
	}
	
	public Expense(
			@NotNull @Size(min = 1, max = 200, message = "expense name must not be blank") String expense,
			@NotNull @Size(min = 5, max = 200, message = "Vendor must not be blank") String vendor,
			@NotNull @Min(value=1, message="Please enter a value") Integer amount,
			@NotNull @Size(min = 5, max = 200, message = "Description must not be blank") String description,
			Long id
			) {
		super();
		this.id = id;
		this.expense = expense;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getExpense() {
		return expense;
	}
	public void setExpense(String expense) {
		this.expense = expense;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
    
    
}
