package store.logic;

import java.util.List;

public interface FeedbackCatalog {
	List<Feedback> getPage(int page);
	void add(Feedback feedback);
	void delete(int feedbackId);
	List<Feedback> getItemFeedback(int itemId);
}
