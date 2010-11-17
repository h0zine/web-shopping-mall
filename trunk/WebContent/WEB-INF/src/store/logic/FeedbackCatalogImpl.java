package store.logic;

import java.util.List;
import store.dao.FeedbackDao;

public class FeedbackCatalogImpl implements FeedbackCatalog {

	private FeedbackDao dao;
	
	public void setFeedbackDao(FeedbackDao dao) {
		this.dao = dao;
	}
	
	public List<Feedback> getPage(int page) {
		return this.dao.getPage(page);
	}

	public void add(Feedback feedback) {
		this.dao.add(feedback);
	}

	public void delete(int feedbackId) {
		this.dao.delete(feedbackId);
	}

	public List<Feedback> getItemFeedback(int itemId) {
		return this.dao.getItemFeedback(itemId);
	}

}
