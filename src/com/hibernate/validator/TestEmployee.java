package com.hibernate.validator;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class TestEmployee {
	
	public static void main(String[] args) {
	
		Employee emp=new Employee();
		emp.setFirtName("Akshay");
		
		 ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		 Validator   validator = factory.getValidator();
		 
		 Set<ConstraintViolation<Employee>> constraintViolations =
			      validator.validate( emp );
		 
		 Iterator<ConstraintViolation<Employee>> itr = constraintViolations.iterator();
		 
		 while(itr.hasNext()) {
			 
			 System.out.println("Mandatory check failed for>>"+itr.next().getPropertyPath());
		 }
	

	}

}
