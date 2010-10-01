package store.web.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.validation.BindException;
import org.springframework.web.util.WebUtils;
import org.springframework.dao.DataIntegrityViolationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.web.WebConstants;
import store.logic.Shop;
import store.logic.User;

public class UserEntryFormController extends SimpleFormController 
{
	private Shop shopService;
	
	public Shop getShopService() {
		return this.shopService;
	}
	
	public void setShopService(Shop shop) {
		this.shopService = shop;
	}
	
	protected ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse res, Object cmd, BindException exception) throws Exception
	{
		// Command의 cast
		User user = (User) cmd;

		exception.reject("error.duplicate");
		return showForm(req, res, exception);
		/*
		
		try {
			this.shopService.entryUser(user);
			
			// 세션에 회전 정보를 등록
			WebUtils.setSessionAttribute(req, WebConstants.USER_KEY, user);
			ModelAndView modelAndView = new ModelAndView(getSuccessView());
			modelAndView.addObject(getCommandName(), user);
			return modelAndView;
		}
		catch (DataIntegrityViolationException e) {
			// 회원 ID의 중복 시, 폼 송신원으로 이동
			exception.reject("error.duplicate");
			return showForm(req, res, exception);
		}
		*/
	}
}
