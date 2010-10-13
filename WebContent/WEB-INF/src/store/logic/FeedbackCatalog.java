package store.logic;

import java.util.List;

public interface FeedbackCatalog {
	List getPage(int page);
	void add(Feedback feedback);
	void delete(int feedbackId);
	List getItemFeedback(int itemId);
}
