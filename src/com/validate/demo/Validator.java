package com.validate.demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Validator {

	public static List<String> validateMandatory(Object objectToValidate)
			throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

		List<String> failedParams = new ArrayList<String>();
		Field[] declaredFields = objectToValidate.getClass().getDeclaredFields();

		for (Field field : declaredFields) {

			Annotation annotation = field.getAnnotation(Mandatory.class);

			if (annotation != null) {

				Mandatory required = (Mandatory) annotation;

				if (required.value()) {

					field.setAccessible(true);

					if (field.get(objectToValidate) == null || field.get(objectToValidate).toString().isEmpty()) {
						// throw new
						// RequiredFieldException(objectToValidate.getClass().getName()+"."+field.getName());
						failedParams.add(field.getName());
					}
				}
			}
		}
		return failedParams;

	}
}
