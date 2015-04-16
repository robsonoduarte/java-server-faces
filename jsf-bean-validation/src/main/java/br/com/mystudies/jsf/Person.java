package br.com.mystudies.jsf;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Person {

	@NotNull
	private String name;
	
	@Min(value=1)
	private Integer age;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

}
