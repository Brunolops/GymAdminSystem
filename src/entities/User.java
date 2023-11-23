package entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.UserException;

public class User {

	private String name;
	private String lastName;
	private String email;
	private Integer age;
	private Double height;

	public User() {

	}

	public User(String name, String lastName, String email, Integer age, Double height) {
		validateName(name);
		this.name = name;
		validateEmail(email);
		this.lastName = lastName;
		this.email = email;
		validateAge(age);
		this.age = age;
		validateHeight(height);
		this.height = height;
	}

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public static boolean validateName(String name) {

		// Regex to check valid username.
		String regex = "^[A-Za-z]\\w{9,29}$";

		// Compile the ReGex
		Pattern p = Pattern.compile(regex);

		// If the username is empty
		// return false
		if (name == null) {
			throw new UserException("Favor inserir o nome completo");
		}

		// Pattern class contains matcher() method
		// to find matching between given username
		// and regular expression.
		Matcher m = p.matcher(name);

		// Return if the username
		// matched the ReGex
		return m.matches();
	}

	private void validateEmail(String email) {
		if (email == null || email.isEmpty() || !email.contains("@")) {
			throw new UserException("Favor inserir um e-mail válido");
		}
	}

	private void validateAge(Integer age) {
		if (age != null && age < 18) {
			throw new UserException("Desculpe, tela de acesso permitido apenas para maiores de 18 anos. ");
		}
	}

	private void validateHeight(Double height) {
		if (height != null) {
			String heightString = String.valueOf(height);

			if (height < 0) {
				throw new UserException("A altura não pode ser um valor negativo.");
			}

			if (heightString.contains(".") && !heightString.contains(",")) {
				throw new UserException("Use vírgula como separador decimal para a altura.");
			}
		}
	}

	@Override
	public String toString() {
		return name + " " + lastName + "\n" + email + "\n" + age + "\n" + height + "\n";
	}
}
