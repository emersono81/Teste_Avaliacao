package com.zup.testeselecao.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zup.testeselecao.dao.EmployeeDAO;
import com.zup.testeselecao.model.Employee;

/**
 * controlador Spring MVC para manipular solicitações das pessoas
 * @author Emerson Oliveira
 *
 */
@RestController
@RequestMapping("/company")
public class EmployeeController {

	@Autowired
	EmployeeDAO employeeDAO;

	/**
	 * 
	 * @param emp
	 * @return
	 * para criar um novo Employee - banco de dados "pessoas"
	 */
	@PostMapping("/employees")
	public ResponseEntity<Void> createEmployee(@Valid @RequestBody Employee emp) {
		Employee employee = employeeDAO.save(emp);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId())
                .toUri();
		return ResponseEntity.created(location).build();	
	}

	/**
	 * 
	 * @return
	 * para obter todos os employees - banco de dados pessoas
	 */
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeDAO.findAll();
		if (employees.size() > 0)
			return ResponseEntity.ok().body(employees);
		return ResponseEntity.noContent().build();
	}

	/**
	 * 
	 * @param empid
	 * @return
	 * obter o employee por empid - banco de dados pessoas
	 */
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long empid) {
		Employee emp = employeeDAO.findOne(empid);
		if (emp == null)
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok().body(emp);
	}

	/**
	 * 
	 * @param empid
	 * @param empDetails
	 * @return
	 * atualizar um employee por empid  - banco de dados pessoas
	 */
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long empid,
			@Valid @RequestBody Employee empDetails) {
		Employee emp = employeeDAO.findOne(empid);
		if (emp == null)
			return ResponseEntity.noContent().build();
		emp.setNome(empDetails.getNome());
		emp.setCpf(empDetails.getCpf());
		emp.setEndereco(empDetails.getEndereco());
		emp.setDataNascimento(empDetails.getDataNascimento());

		Employee updateEmployee = employeeDAO.save(emp);
		return ResponseEntity.ok().body(updateEmployee);
	}

	
	/**
	 * 
	 * @param empid
	 * @return
	 * Deleta um employee por empid - banco de dados pessoas
	 */
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") Long empid) {
		Employee emp = employeeDAO.findOne(empid);
		if (emp == null)
			return ResponseEntity.noContent().build();
		employeeDAO.delete(emp);
		return ResponseEntity.ok().build();
	}
}
