package store.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;

import store.logic.User;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

	private static final String INSERT
					= "INSERT INTO wiz_member (id, passwd, name, photo, icon, nick, resno, email, tphone, hphone, comtel, homepage, " +
					  "post, address1, address2, reemail, resms, birthday, bgubun, marriage, memorial, scholarship, job, income, car, " +
					  "hobby, consph, conprd, level, recom, visit, visit_time, intro, memo, addinfo1, addinfo2, addinfo3, addinfo4, " +
					  "addinfo5, wdate, contury) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_BY_ID
					= "SELECT * FROM wiz_member WHERE id = ?";
	private static final String SELECT_BY_EMAIL
					= "SELECT * FROM wiz_member WHERE email = ?";
	private static final String DELETE_BY_ID
					= "DELETE FROM wiz_member WHERE id = ?";
	private static final String DELETE_BY_EMAIL
					= "DELETE FROM wiz_member WHERE email = ?";
	private static final String SELECT_ALL
					= "SELECT * FROM wiz_member ORDER BY id";
	private static final String SELECT_PAGE
					= "SELECT * FROM wiz_member ORDER BY id LIMIT ?,?";
	private static final String UPDATE_BY_ID
					= "UPDATE wiz_member SET" +
					"passwd = ?, name = ?, photo = ?, icon = ?, nick = ?, resno = ?, email = ?, tphone = ?," +
					"hphone = ?, comtel = ?, homepagepost = ?, address1 = ?, address2 = ?, reemail = ?, "+
					"resms = ?, birthday = ?, bgubun = ?, marriage = ?, memorial = ?, scholarship = ?, job = ?, " +
					"income = ?, car = ?, hobby = ?, consph = ?, conprd = ?, level = ?, recom = ?, visit = ?, " +
					"visit_time = ?, intro = ?, memo = ?, addinfo1 = ?, addinfo2 = ?, addinfo3 = ?, addinfo4 = ?" +
					"addinfo5 = ?, wdate = ?, contury = ?" +
					"WHERE id = ?";
	private static final String UPDATE_BY_EMAIL
					= "UPDATE wiz_member SET" +
					"id = ?, passwd = ?, name = ?, photo = ?, icon = ?, nick = ?, resno = ?, tphone = ?," +
					"hphone = ?, comtel = ?, homepagepost = ?, address1 = ?, address2 = ?, reemail = ?, "+
					"resms = ?, birthday = ?, bgubun = ?, marriage = ?, memorial = ?, scholarship = ?, job = ?, " +
					"income = ?, car = ?, hobby = ?, consph = ?, conprd = ?, level = ?, recom = ?, visit = ?, " +
					"visit_time = ?, intro = ?, memo = ?, addinfo1 = ?, addinfo2 = ?, addinfo3 = ?, addinfo4 = ?" +
					"addinfo5 = ?, wdate = ?, contury = ?" +
					"WHERE email = ?";
	
	private class UserPreparedStatementSetterForInsert implements PreparedStatementSetter {
		private User user;
		
		public UserPreparedStatementSetterForInsert(User user) {
			this.user = user;
		}
		
		public void setValues(PreparedStatement ps) throws SQLException {
			ps.setString(1, this.user.getId());
			ps.setString(2, this.user.getPasswd());
			ps.setString(3, this.user.getName());
			ps.setString(4, this.user.getPhoto());
			ps.setString(5, this.user.getIcon());
			ps.setString(6, this.user.getNick()); 
			ps.setString(7, this.user.getResno()); 
			ps.setString(8, this.user.getEmail()); 
			ps.setString(9, this.user.getTphone()); 
			ps.setString(10, this.user.getHphone()); 
			ps.setString(11, this.user.getComtel());
			ps.setString(12, this.user.getHomepage());
			ps.setString(13, this.user.getPost());
			ps.setString(14, this.user.getAddress1());
			ps.setString(15, this.user.getAddress2());
			ps.setString(16, this.user.getReemail());
			ps.setString(17, this.user.getResms());
			ps.setString(18, this.user.getBirthday());
			ps.setString(19, this.user.getBgubun());
			ps.setString(20, this.user.getMarriage());
			ps.setString(21, this.user.getMemorial());
			ps.setString(22, this.user.getScholarship());
			ps.setString(23, this.user.getJob());
			ps.setString(24, this.user.getIncome());
			ps.setString(25, this.user.getCar());
			ps.setString(26, this.user.getHobby());
			ps.setString(27, this.user.getConsph());
			ps.setString(28, this.user.getConprd());
			ps.setString(29, this.user.getLevel());
			ps.setString(30, this.user.getRecom());
			ps.setString(31, this.user.getVisit());
			ps.setDate(32, new java.sql.Date(this.user.getVisit_time().getTime()));
			ps.setString(33, this.user.getIntro());
			ps.setString(34, this.user.getMemo());
			ps.setString(35, this.user.getAddinfo1());
			ps.setString(36, this.user.getAddinfo2());
			ps.setString(37, this.user.getAddinfo3());
			ps.setString(38, this.user.getAddinfo4());
			ps.setString(39, this.user.getAddinfo5());
			ps.setDate(40, new java.sql.Date(this.user.getWdate().getTime()));
			ps.setString(41, this.user.getContury());
		}
	}

	private class PstmtSetterSetId implements PreparedStatementSetter
	{
		private String id;
		
		public PstmtSetterSetId(String id) {
			this.id = id;
		}
		
		public void setValues(PreparedStatement pstmt) throws SQLException {
			pstmt.setString(1, id);
		}
	}

	private class PstmtSetterSetEmail implements PreparedStatementSetter
	{
		private String email;
		
		public PstmtSetterSetEmail(String email) {
			this.email = email;
		}
		
		public void setValues(PreparedStatement pstmt) throws SQLException {
			pstmt.setString(1, email);
		}
	}

	private class PstmtSetterSelectPage implements PreparedStatementSetter
	{
		private int page;
		private static final int PAGE_SIZE = 30;
		
		public PstmtSetterSelectPage(int page) {
			if (page <= 0)
				page = 1;
			
			this.page = page;
		}
		
		public void setValues(PreparedStatement pstmt) throws SQLException {
			int start, end;
			start = (page - 1) * PAGE_SIZE;
			end   = page * PAGE_SIZE;
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
		}
	}

	private class PstmtSetterUpdateById implements PreparedStatementSetter
	{
		private User user;
		
		public PstmtSetterUpdateById(User user) {
			this.user = user;
		}
		
		public void setValues(PreparedStatement pstmt) throws SQLException {
			pstmt.setString(1, this.user.getPasswd());
			pstmt.setString(2, this.user.getName());
			pstmt.setString(3, this.user.getPhoto());
			pstmt.setString(4, this.user.getIcon());
			pstmt.setString(5, this.user.getNick()); 
			pstmt.setString(6, this.user.getResno()); 
			pstmt.setString(7, this.user.getEmail()); 
			pstmt.setString(8, this.user.getTphone()); 
			pstmt.setString(9, this.user.getHphone()); 
			pstmt.setString(10, this.user.getComtel());
			pstmt.setString(11, this.user.getHomepage());
			pstmt.setString(12, this.user.getPost());
			pstmt.setString(13, this.user.getAddress1());
			pstmt.setString(14, this.user.getAddress2());
			pstmt.setString(15, this.user.getReemail());
			pstmt.setString(16, this.user.getResms());
			pstmt.setString(17, this.user.getBirthday());
			pstmt.setString(18, this.user.getBgubun());
			pstmt.setString(19, this.user.getMarriage());
			pstmt.setString(20, this.user.getMemorial());
			pstmt.setString(21, this.user.getScholarship());
			pstmt.setString(22, this.user.getJob());
			pstmt.setString(23, this.user.getIncome());
			pstmt.setString(24, this.user.getCar());
			pstmt.setString(25, this.user.getHobby());
			pstmt.setString(26, this.user.getConsph());
			pstmt.setString(27, this.user.getConprd());
			pstmt.setString(28, this.user.getLevel());
			pstmt.setString(29, this.user.getRecom());
			pstmt.setString(30, this.user.getVisit());
			pstmt.setDate(31, new java.sql.Date(this.user.getVisit_time().getTime()));
			pstmt.setString(32, this.user.getIntro());
			pstmt.setString(33, this.user.getMemo());
			pstmt.setString(34, this.user.getAddinfo1());
			pstmt.setString(35, this.user.getAddinfo2());
			pstmt.setString(36, this.user.getAddinfo3());
			pstmt.setString(37, this.user.getAddinfo4());
			pstmt.setString(38, this.user.getAddinfo5());
			pstmt.setDate(39, new java.sql.Date(this.user.getWdate().getTime()));
			pstmt.setString(40, this.user.getContury());			
			pstmt.setString(41, this.user.getId());
		}
	}

	private class PstmtSetterUpdateByEmail implements PreparedStatementSetter {
		private User user;
		
		public PstmtSetterUpdateByEmail(User user) {
			this.user = user;
		}
		
		public void setValues(PreparedStatement pstmt) throws SQLException {
			pstmt.setString(1, this.user.getId());
			pstmt.setString(2, this.user.getPasswd());
			pstmt.setString(3, this.user.getName());
			pstmt.setString(4, this.user.getPhoto());
			pstmt.setString(5, this.user.getIcon());
			pstmt.setString(6, this.user.getNick()); 
			pstmt.setString(7, this.user.getResno()); 
			pstmt.setString(8, this.user.getTphone()); 
			pstmt.setString(9, this.user.getHphone()); 
			pstmt.setString(10, this.user.getComtel());
			pstmt.setString(11, this.user.getHomepage());
			pstmt.setString(12, this.user.getPost());
			pstmt.setString(13, this.user.getAddress1());
			pstmt.setString(14, this.user.getAddress2());
			pstmt.setString(15, this.user.getReemail());
			pstmt.setString(16, this.user.getResms());
			pstmt.setString(17, this.user.getBirthday());
			pstmt.setString(18, this.user.getBgubun());
			pstmt.setString(19, this.user.getMarriage());
			pstmt.setString(20, this.user.getMemorial());
			pstmt.setString(21, this.user.getScholarship());
			pstmt.setString(22, this.user.getJob());
			pstmt.setString(23, this.user.getIncome());
			pstmt.setString(24, this.user.getCar());
			pstmt.setString(25, this.user.getHobby());
			pstmt.setString(26, this.user.getConsph());
			pstmt.setString(27, this.user.getConprd());
			pstmt.setString(28, this.user.getLevel());
			pstmt.setString(29, this.user.getRecom());
			pstmt.setString(30, this.user.getVisit());
			pstmt.setDate(31, new java.sql.Date(this.user.getVisit_time().getTime()));
			pstmt.setString(32, this.user.getIntro());
			pstmt.setString(33, this.user.getMemo());
			pstmt.setString(34, this.user.getAddinfo1());
			pstmt.setString(35, this.user.getAddinfo2());
			pstmt.setString(36, this.user.getAddinfo3());
			pstmt.setString(37, this.user.getAddinfo4());
			pstmt.setString(38, this.user.getAddinfo5());
			pstmt.setDate(39, new java.sql.Date(this.user.getWdate().getTime()));
			pstmt.setString(40, this.user.getContury());
			pstmt.setString(41, this.user.getEmail()); 
		}
	}
	
	private class Rse implements ResultSetExtractor {

		public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

			return null;
		}
		
	}

	public void create(User user) {
		getJdbcTemplate().update(UserDaoImpl.INSERT, new UserPreparedStatementSetterForInsert(user));
	}

	public User getById(String id) {
		
		return (User) getJdbcTemplate().query(UserDaoImpl.SELECT_BY_ID, rse)
	}
	
	public User getByEmail(String email) {
		
	}
	
	public void deleteById(String id) {
		
	}
	
	public void deleteByEmail(String email) {
		
	}
	
	public List getAllList() {
		
	}
	
	public List getPageList(int page) {
		
	}
	
	public void updateById(User user) {
		
	}
	
	public void updateByEmail(User user) {
		
	}
}
