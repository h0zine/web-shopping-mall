package store.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.util.StringUtils;

import store.logic.Category;

public class CategoryEntryValidator implements Validator {

	public boolean supports(Class clazz) {
		return Category.class.isAssignableFrom(clazz);
	}

	public void validate(Object command, Errors errors) {
		
		Category category = (Category) command;
		
		if (category.getParent() == null) {
			category.setParent(new Integer(0));
		}
		
		if (!StringUtils.hasLength(category.getName())) {
			errors.rejectValue("name", "error.required");
		}

		if (errors.hasErrors()) {
			errors.reject("error.input");
		}
	}

}
