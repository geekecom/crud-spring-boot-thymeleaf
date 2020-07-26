package com.lorenzolerate.rs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lorenzolerate.rs.model.Employee;
import com.lorenzolerate.rs.model.Office;
import com.lorenzolerate.rs.model.Technology;
import com.lorenzolerate.rs.repo.EmployeeRepo;
import com.lorenzolerate.rs.repo.OfficeRepo;
import com.lorenzolerate.rs.repo.TechnologyRepo;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeRepo employeeRepo;

	@Autowired
	OfficeRepo officeRepo;

	@Autowired
	TechnologyRepo technologyRepo;

	@RequestMapping()
	public String showAllEmployees(Model model) {
		List<Employee> allEmployees = employeeRepo.findAll(Sort.by("id"));
		model.addAttribute("allEmployees", allEmployees);
		return "home";
	}

	@RequestMapping("view/{id}")
	public String showEmployee(@PathVariable Integer id, Model model) {
		Employee employee = employeeRepo.findById(id).get();
		model.addAttribute("employee", employee);
		return "employeeDetails";
	}

	@RequestMapping("delete/{id}")
	public String deleteEmployee(@PathVariable Integer id, Model model) {
		employeeRepo.deleteById(id);
		System.out.println("Deleted employee with id: " + id);
		List<Employee> allEmployees = employeeRepo.findAll(Sort.by("id"));
		model.addAttribute("allEmployees", allEmployees);
		return "home :: #employee-table";
	}

	@RequestMapping("edit/{id}")
	public String showUpdateForm(@PathVariable Integer id, Model model) {
		Employee employee = employeeRepo.findById(id).get();

		List<Office> allOffices = officeRepo.findAll(Sort.by("id"));
		model.addAttribute("allOffices", allOffices);

		List<Technology> allTechnologies = technologyRepo.findAll(Sort.by("id"));
		model.addAttribute("allTechnologies", allTechnologies);

		model.addAttribute("employee", employee);
		return "employeeUpdateForm";
	}

	@PostMapping("update")
	public String updateEmployee(@ModelAttribute("employee") Employee employee, Model model) {

		// find office by location
		Office office = officeRepo.findByLocation(employee.getOffice().getLocation());
		employee.setOffice(office);

		// find technologies
		for (Technology technology : employee.getTechnologies()) {
			technology.setId(technologyRepo.findByName(technology.getName()).getId());
		}

		employeeRepo.save(employee);

		List<Employee> allEmployees = employeeRepo.findAll(Sort.by("id"));
		model.addAttribute("allEmployees", allEmployees);

		return "home";
	}

	@RequestMapping("add")
	public String showAddForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);

		List<Office> allOffices = officeRepo.findAll(Sort.by("id"));
		model.addAttribute("allOffices", allOffices);

		List<Technology> allTechnologies = technologyRepo.findAll(Sort.by("id"));
		model.addAttribute("allTechnologies", allTechnologies);

		return "employeeAddForm";
	}

	@PostMapping("create")
	public String createEmployee(@ModelAttribute Employee employee, Model model) {
		// find office by location
		Office office = officeRepo.findByLocation(employee.getOffice().getLocation());
		employee.setOffice(office);

		// find technologies
		for (Technology technology : employee.getTechnologies()) {
			technology.setId(technologyRepo.findByName(technology.getName()).getId());
		}

		employeeRepo.save(employee);

		List<Employee> allEmployees = employeeRepo.findAll(Sort.by("id"));
		model.addAttribute("allEmployees", allEmployees);

		return "home";
	}
}
