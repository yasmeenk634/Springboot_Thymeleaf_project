package com.yasmeen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.yasmeen.request.RequestEmployee;
import com.yasmeen.service.EmployeeService;
import com.yasmeen.model.Employee;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	//Display List of employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "index";
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addEmployees(@RequestBody RequestEmployee request){
		String result=employeeService.addEmployee(request);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute ("employee") Employee employee) {
		//save employee to DB.
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable("id")long id,Model model) {
		Employee employee=employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "update_employee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id")long id) {
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}
//	@RequestMapping(value="/bh" , method=RequestMethod.GET)
//	public List<Employee>getAllEmployee(){
//		return employeeService.getAllEmployees();
//	}
}
