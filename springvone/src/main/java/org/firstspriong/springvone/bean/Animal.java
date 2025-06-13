package org.firstspriong.springvone.bean;

import org.springframework.stereotype.Component;

@Component("animalObj")
public class Animal {
	String type;
	Float weight;
	Integer age;
	String name;
	
	
	
	public Animal() {
		super();
	}



	public Animal(String type, Float weight, Integer age, String name) {
		super();
		this.type = type;
		this.weight = weight;
		this.age = age;
		this.name = name;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public Float getWeight() {
		return weight;
	}



	public void setWeight(Float weight) {
		this.weight = weight;
	}



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "Animal [type=" + type + ", weight=" + weight + ", age=" + age + ", name=" + name + "]";
	}
	
	
}
