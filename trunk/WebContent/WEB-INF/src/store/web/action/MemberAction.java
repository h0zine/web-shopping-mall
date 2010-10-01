package store.web.action;

import org.apache.struts.actions.MappingDispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

import store.logic.Shop;
import store.logic.User;
import store.web.form.UserForm;

public class MemberAction extends MappingDispatchAction {

	private Shop shop;
	
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	public ActionForward join (ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		User user = new User();

		// set user default information using property setting.
		
		UserForm userForm = new UserForm();
		userForm.setUser(user);
		
		req.getSession().setAttribute("userForm", userForm);
		return mapping.findForward("success");
	}
}
