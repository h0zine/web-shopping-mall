package store.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import store.logic.Feedback;

public class FeedbackDaoImpl extends JdbcDaoSupport implements FeedbackDao {
	
	private final static int PAGE_SIZE = 30;
	private final static String SELECT_PAGE = "SELECT * FROM feedback ORDER BY id LIMIT ?, ?";
	private final static String INSERT = "INSERT INTO feedback (item_id, writer_name, writer_id, comment, point, regdate)" +
			"VALUES (?,?,?,?,?,sydate())";
	private final static String DELETE = "DELETE FROM feedback WHERE id = ?";
	private final static String SELECT_ITEM = "SELECT * FROM feedback ORDER BY id WHERE item_id = ?";
	
	private class RMFeedBack implements RowMapper {

		public Object mapRow(ResultSet rs, int rownum) throws SQLException {
			Feedback feedback = new Feedback();
			
			feedback.setId(rs.getInt("id"));
			feedback.setItemId(rs.getInt("item_id"));
			feedback.setWriterId(rs.getString("writer_id"));
			feedback.setWriterName(rs.getString("writer_name"));
			feedback.setPoint(rs.getInt("point"));
			feedback.setComment(rs.getString("comment"));
			feedback.setRegDate(new java.sql.Date(rs.getDate("reg_date").getTime()));

			return feedback;
		}
	}
	
	private class PSFeedBack implements PreparedStatementSetter {
		private Feedback feedback;
		
		public PSFeedBack(Feedback feedback) {
			this.feedback = feedback;
		}

		public void setValues(PreparedStatement pstmt) throws SQLException {
			pstmt.setInt(1, feedback.getId());
			pstmt.setString(2, feedback.getWriterName());
			pstmt.setString(3, feedback.getWriterId());
			pstmt.setString(4, feedback.getComment());
			pstmt.setInt(5, feedback.getPoint());
		}
		
	}
	
	public List getPage(int page) {
		if (page <= 0) page = 1;
		int start = (page - 1) * PAGE_SIZE;
		int end = page * PAGE_SIZE;

		return this.getJdbcTemplate().query(SELECT_PAGE, new Object[] {new Integer(start), new Integer(end)}, new RMFeedBack());
	}
	
	public void add(Feedback feedback) {
		this.getJdbcTemplate().update(INSERT, new PSFeedBack(feedback));
	}
	
	public void delete(int feedbackId) {
		this.getJdbcTemplate().update(DELETE, new Object[] {new Integer(feedbackId)});
	}
	
	public List getItemFeedback(int itemId) {
		return this.getJdbcTemplate().query(SELECT_ITEM, new Object[] {new Integer(itemId)}, new RMFeedBack());
	}

}
