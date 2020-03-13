package org.ms.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;


import org.ms.thymeleafdemo.entity.Employee;
import org.ms.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/list")
	public String listEmployee(Model model) {
		
		List<Employee> employees= employeeService.findAll();
			
		model.addAttribute("employees",employees);
		
		return "list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String addEmployee(Model model) {
		Employee theEmployee = new Employee();
		model.addAttribute("employee",theEmployee);
		return "employees/add-employee-form";
	}
	
	@PostMapping ("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		employeeService.save(theEmployee);
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormUpdate")
	public String showFormUpdate(@RequestParam("employeeId") int theId, Model model) {
		Employee theEmployee = employeeService.findEmployeeById(theId);
		model.addAttribute("employee",theEmployee);
		return "employees/add-employee-form";
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("employeeId") int theId) {
		employeeService.deleteById(theId);
		return "redirect:/employees/list";
	}
	
	
	
}
