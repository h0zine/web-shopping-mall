package store.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.core.PreparedStatementSetter;

import store.logic.User;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

	private static final String INSERT
					= "INSERT INTO wiz_member (id, passwd, name, photo, icon, nick, resno, email, tphone, hphone, comtel, homepage, " +
					  "post, address1, address2, reemail, resms, birthday, bgubun, marriage, memorial, scholarship, job, income, car, " +
					  "hobby, consph, conprd, level, recom, visit, visit_time, intro, memo, addinfo1, addinfo2, addinfo3, addinfo4, " +
					  "addinfo5, wdate, contury) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

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
	
	public void create(User user) {
		getJdbcTemplate().update(UserDaoImpl.INSERT, new UserPreparedStatementSetterForInsert(user));
	}

}
