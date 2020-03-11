package com.blogspot.javabyrajasekhar.springbootfullstack.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.blogspot.javabyrajasekhar.springbootfullstack.model.Employee;
import com.blogspot.javabyrajasekhar.springbootfullstack.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public String getEmployeeList(Model model) {
	
		  model.addAttribute("empList", employeeService.getEmpList());
		return "index";
	}

	@PostMapping("/createEmployee")
	public String addEmployee(@Valid Employee emp,BindingResult bindingResult) {
		
		if(null !=bindingResult && bindingResult.getAllErrors().size()>0) {
			return "addEditEmployee";
		}
		employeeService.saveEmployee(emp);
		return "redirect:/";
	}
	
	@GetMapping(path = {"/edit", "/edit/{id}"})
    public String editEmployeeById(Model model, @PathVariable("id") Optional<Long> id) 
                            throws Exception 
    {
        if (id.isPresent()) {
            Employee entity = employeeService.getEmployeeById(id.get());
            model.addAttribute("employee", entity);
        } else {
            model.addAttribute("employee", new Employee());
        }
        return "addEditEmployee";
    }
	
	 @RequestMapping(path = "/delete/{id}")
	    public String deleteEmployeeById(Model model, @PathVariable("id") Long id) 
	                            throws Exception 
	    {
		 employeeService.deleteEmployeeById(id);
	        return "redirect:/";
	    }
}
