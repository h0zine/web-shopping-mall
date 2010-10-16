package store.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import store.logic.Notice;

public class NoticeDaoImpl extends JdbcDaoSupport implements NoticeDao {

	private static final String INSERT = "INSERT INTO notice (title,content,reg_date,popup) VALUES (?,?,?,?)";
	private static final String SELECT = "SELECT * FROM notice WHERE notice_id = ?";
	private static final String DELETE = "DELETE FROM notice WHERE notice_id = ?";
	private static final String UPDATE = "UPDATE notice SET title=?,content=?,reg_date=?,popup=? WHERE notice_id=?";
	private static final String SELECT_ALL = "SELECT * FROM notice ORDER BY reg_date DESC";
	
	public void add(Notice notice) {
		this.getJdbcTemplate().update(INSERT, new Object[] {notice.getTitle(), notice.getContent(), new java.sql.Date(notice.getRegDate().getTime()), new Boolean(notice.isPopup())});
	}

	private class RseNotice implements ResultSetExtractor
	{
		public Object extractData(ResultSet rs) throws SQLException, DataAccessException 
		{
			if (rs.next()) {
				Notice notice = new Notice();
				notice.setNoticeId(rs.getInt("notice_id"));
				notice.setTitle(rs.getString("title"));
				notice.setContent(rs.getString("content"));
				notice.setRegDate(new java.sql.Date(rs.getDate("reg_date").getTime()));
				notice.setPopup(rs.getBoolean("popup"));
				return notice;
			}
			else 
				throw new DataRetrievalFailureException("Can't find the notice.");
		}
	}
	
	public Notice get(int noticeId) {
		return (Notice) this.getJdbcTemplate().query(SELECT, new Object[] {new Integer(noticeId)}, new RseNotice()); 
	}

	public void delete(int noticeId) {
		this.getJdbcTemplate().update(DELETE, new Object[] {new Integer(noticeId)});
	}

	public void update(Notice notice) {
		this.getJdbcTemplate().update(UPDATE, new Object[] {notice.getTitle(), 
															notice.getContent(), 
															new java.sql.Date(new java.util.Date().getTime()), 
															new Boolean(false), 
															new Integer(notice.getNoticeId())});
	}

	public List getAll() {
		return this.getJdbcTemplate().query(SELECT_ALL, new RmInvoice());
	}

	private class RmInvoice implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Notice notice = new Notice();
			notice.setNoticeId(rs.getInt("notice_id"));
			notice.setTitle(rs.getString("title"));
			notice.setContent(rs.getString("content"));
			notice.setRegDate(new java.sql.Date(rs.getDate("reg_date").getTime()));
			notice.setPopup(rs.getBoolean("popup"));
			return notice;
		}
	}
}
