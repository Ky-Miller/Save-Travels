package com.ky.savetravels.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ky.savetravels.models.Expense;
import com.ky.savetravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	private final ExpenseService expenseServ;
	public HomeController(ExpenseService expenseServ) {
		this.expenseServ = expenseServ;
	}

	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("allExpenses", expenseServ.getAll());
		return "expenses/showAll.jsp";
	}
	
	@GetMapping("/show/one/expense/{id}")
	public String showOneExpense(Model model, @PathVariable("id") Long id) {
		model.addAttribute("oneExpense", expenseServ.getOne(id));
		return "expenses/showOne.jsp";
	}
	
	@PostMapping("/expenses")
	public String processNewExpense(@Valid @ModelAttribute("expense") Expense newExpense, BindingResult result) {
		if(result.hasErrors()) {
			return "expenses/showAll.jsp";
		}
		expenseServ.create(newExpense);
		return "redirect:/dashboard";
	}
	
    @RequestMapping("/expenses/process/edit/m/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute(
        "expense", expenseServ.getOne(id)
        );
        return "expenses/edit.jsp";
    }
    
    @PatchMapping("/expenses/process/edit/m/{id}")
    public String processEditExpense(@Valid
    		@ModelAttribute("expense")
    		Expense expense,
    		BindingResult result) {
    	if(result.hasErrors()) {
    		return "expenses/edit.jsp";
    	}
    	expenseServ.editOne(expense);
    	return "redirect:/dashboard";
    }
    
    @DeleteMapping("/expenses/{id}")
    public String deleteExpense(@PathVariable("id")Long id) {
    	expenseServ.delete(id);
    	return "redirect:/dashboard";
    }
}
