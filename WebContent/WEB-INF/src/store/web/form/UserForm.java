package store.web.form;

import org.apache.struts.validator.ValidatorForm;

import store.logic.User;

public class UserForm extends ValidatorForm 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3566927648980668920L;
	private User user;
	
	public User getUser() {
		return this.user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
