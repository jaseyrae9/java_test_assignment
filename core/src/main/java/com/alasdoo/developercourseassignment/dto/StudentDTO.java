package com.alasdoo.developercourseassignment.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class StudentDTO {

	private Integer id;

	@Length(max = 250, message = "Name cannot be longer than 250.")
	@NotBlank(message = "Please, enter a name.")
	private String name;

	@Length(max = 250, message = "Surname cannot be longer than 250.")
	@NotBlank(message = "Please, enter a surname.")
	private String surname;

	@Length(max = 250, message = "Account number cannot be longer than 250.")
	@NotBlank(message = "Please, enter a account name.")
	private String accountName;

	@Length(max = 250, message = "Email cannot be longer than 250.")
	@Email(message = "Email format is incorrect.")
	@NotBlank(message = "Please, enter a email.")
	private String email;

	@NotNull(message = "Please, enter a bank card number.")
	private Integer bankCardNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getBankCardNumber() {
		return bankCardNumber;
	}

	public void setBankCardNumber(Integer bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}
}
