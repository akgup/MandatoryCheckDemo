package com.validate.demo;

import java.util.ArrayList;

public class UserValidator {

	public static void main(String[] args) {
		User user = new User();

		user.setAddress("Pune");

		try {
			ArrayList<String> failedParams = (ArrayList<String>) Validator.validateMandatory(user);

			for(String param:failedParams)
			{
				System.out.println("Mandatory check failed for >>>"+param);
			}
			

		} catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

}
