package store.dao;

import java.util.List;
import store.logic.Feedback;

public interface FeedbackDao {
	List getPage(int page);
	void add(Feedback feedback);
	void delete(int feedbackId);
	List getItemFeedback(int itemId);
}
