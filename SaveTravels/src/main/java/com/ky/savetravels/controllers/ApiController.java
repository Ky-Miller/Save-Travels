package com.ky.savetravels.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ky.savetravels.models.Expense;
import com.ky.savetravels.services.ExpenseService;

@RestController
@RequestMapping("/api")
public class ApiController {

	private final ExpenseService expenseServ;
	
	public ApiController(ExpenseService expenseServ) {
		this.expenseServ = expenseServ;
	}
	
//	Get All
	@GetMapping("/expenses")
	public List<Expense> getAllExpenses(){
		return expenseServ.getAll();
	}
	
	@PostMapping("/expenses/new")
	public Expense createExpense(
			@RequestParam("expense") String expense,
			@RequestParam("vendor") String vendor,
			@RequestParam("amount") Integer amount,
			@RequestParam("description") String description
			)
		{
		Expense newExpense = new Expense(expense, vendor, amount, description);
		return expenseServ.create(newExpense);
	}
	
//	Get One
	@GetMapping("/expenses/{id}")
	public Expense getoneExpense(@PathVariable("id") Long id) {
		return expenseServ.getOne(id);
	}
	
//	Edit
	@PatchMapping("/expenses/{id}")
	public Expense editExpense(
			@PathVariable("id") Long id,
			@RequestParam("expense") String expense,
			@RequestParam("vendor") String vendor,
			@RequestParam("amount") Integer amount,
			@RequestParam("description") String description
			) {
		Expense expenseToBeEdited = new Expense(expense, vendor, amount, description, id);
		return expenseServ.editOne(expenseToBeEdited);
	}
	
	@DeleteMapping("/expenses/{id}")
	public String deleteOneExpense(@PathVariable("id") Long id) {
		return expenseServ.delete(id);
	}
}
