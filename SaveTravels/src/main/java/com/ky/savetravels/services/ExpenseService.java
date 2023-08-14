package com.ky.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ky.savetravels.models.Expense;
import com.ky.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {

	private final ExpenseRepository expenseRepo;
	public ExpenseService(ExpenseRepository expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
	public List<Expense> getAll(){
		return expenseRepo.findAll();
	}
	
	public Expense create(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	public Expense getOne(Long id) {
		Optional<Expense> optionalExpense = expenseRepo.findById(id);
		return optionalExpense.isPresent() ? optionalExpense.get() : null;
//		if(optionalExpense.isPresent()) {
//			return optionalExpense.get();
//		} else {
//			return null;
//		}
	}
	public Expense editOne(Expense expense) {
		return expenseRepo.save(expense);
	}
	public String delete(Long id) {
		expenseRepo.deleteById(id);
		return id + " has been deleted";
	}
}
