package com.zup.testeselecao.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.testeselecao.model.Employee;
import com.zup.testeselecao.repository.EmployeeRepository;

/**
 * 
 * @author Emerson Oliveira
 *
 */
@Service
public class EmployeeDAO {

	@Autowired
	EmployeeRepository employeeRepository;

	/**
	 * 
	 * @param emp
	 * @return 
	 * para salvar o employee
	 */
	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
	}

	/**
	 * 
	 * @return
	 * retorna todos os employees.
	 */
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	/**
	 * 
	 * @param empid
	 * @return
	 * retorna o employee por empid.
	 */
	public Employee findOne(Long empid) {
		return employeeRepository.findOne(empid);
	}


	/**
	 * 
	 * @param emp
	 * deleta o employee por empid.
	 */
	public void delete(Employee emp) {
		employeeRepository.delete(emp);
	}

}
