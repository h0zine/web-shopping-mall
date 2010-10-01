package store.web.form;

import org.apache.struts.validator.ValidatorForm;

import store.logic.User;

public class UserForm extends ValidatorForm 
{
	private User user;
	
	public User getUser() {
		return this.user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
