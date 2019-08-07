package com.zup.testeselecao.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 
 * @author Emerson Oliveira Essa é uma classe de entidade JPA com o nome da
 *         classe e os nomes de campo são idênticos aos nomes de colunas da
 *         tabela "employees" no banco de dados "pessoas"
 */
@Entity
@Table(name = "Employees")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank(message = "{nome.not.blank}") // Verifica se o campo não está nulo ou vazio - consulta o "ValidationMessages.properties" dentro de "src/main/resources"									 
	private String nome;

	@NotBlank(message = "{cpf.not.blank}") // Verifica se o campo não está nulo ou vazio - consulta o "ValidationMessages.properties" dentro de "src/main/resources"										
	private String cpf;

	@NotBlank(message = "{endereco.not.blank}") // Verifica se o campo não está nulo ou vazio - consulta o "ValidationMessages.properties" dentro de "src/main/resources"						 
	private String endereco;

	// @NotBlank (message = "{dataNascimento.not.blank}") //Verifica se o campo não está nulo ou vazio - consulta o "ValidationMessages.properties" dentro de "src/main/resources"
	private Date dataNascimento;

	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	
	
}
