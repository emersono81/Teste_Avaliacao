package com.zup.testeselecao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.testeselecao.model.Employee;

/**
 * 
 * @author Emerson Oliveira
 *
 * interface estende a interface JpaRepository do Spring Data JPA.
 * O JpaRepository define métodos CRUD padrão, além de operações 
 * específicas do JPA. Não precisamos escrever código de implementação 
 * porque o Spring Data JPA gerará o código necessário em tempo de execução,
 *  na forma de instâncias de proxy.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}