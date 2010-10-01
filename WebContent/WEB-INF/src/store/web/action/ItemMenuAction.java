package store.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import store.web.form.ItemMenuForm;

import store.logic.Shop;

public class ItemMenuAction extends MappingDispatchAction 
{
	
	private Shop shopService;
	
	public void setShopService(Shop shopService)
	{
		this.shopService = shopService;
	}
	
	public ActionForward findAll(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ItemMenuForm itemMenuForm = (ItemMenuForm) form;
		
		// 상품 리스트 얻기
		/*
		List<?> itemList = shopService.getItemList();
		itemMenuForm.setItemList(itemList);
		*/
		return mapping.findForward("success");
	}
	
	
}
