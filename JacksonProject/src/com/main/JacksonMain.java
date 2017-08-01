package com.main;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

public class JacksonMain {

	public static void main(String[] args) {
		System.out.println("Inside main");
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = "{\"name\":\"Mahesh\",\"age\":21}";
		Student student;
		Animal animal= new Animal();
		animal.setDomestic(true);
		animal.setTypeofEye("RED");
		try {
			student = objectMapper.readValue(jsonString, Student.class);
			System.out.println("sherin the student is "+student.getName()); 
			System.out.println(objectMapper.writeValueAsString(student));
			System.out.println(objectMapper.writeValueAsString(animal));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
