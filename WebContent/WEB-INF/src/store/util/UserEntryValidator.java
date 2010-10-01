package store.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.util.StringUtils;

import store.logic.User;

public class UserEntryValidator implements Validator {

	public boolean supports(Class clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object command, Errors errors) {
		
		User user = (User) command;
		
		if (!StringUtils.hasLength(user.getId())) {
			errors.rejectValue("id", "error.required");
		}
		
		if (!StringUtils.hasLength(user.getPasswd())) {
			errors.rejectValue("passwd", "error.required");
		}
		
		if (!StringUtils.hasLength(user.getName())) {
			errors.rejectValue("name", "error.required");
		}
		
		if (!StringUtils.hasText(user.getPost())) {
			errors.rejectValue("post", "error.required");
		}
		
		if (!StringUtils.hasText(user.getAddress1())) {
			errors.rejectValue("address1", "error.required");
		}
		
		if (!StringUtils.hasText(user.getNick())) {
			errors.rejectValue("nick", "error.required");
		}
		
		if (!StringUtils.hasText(user.getTphone())) {
			errors.rejectValue("tphone", "error.required");
		}

		if (errors.hasErrors()) {
			// ������ ������ ��� �޽��� �Է�, ���� �޽��� �߰�
			errors.reject("error.input");
		}
	}

}
