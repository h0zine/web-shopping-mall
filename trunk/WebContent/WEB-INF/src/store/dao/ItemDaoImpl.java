package store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.core.PreparedStatementSetter;

import store.logic.Item;

public class ItemDaoImpl extends JdbcDaoSupport implements ItemDao {

	protected static final int PAGE_SIZE = 30;
	
	private static final String SELECT_ALL = "SELECT * FROM item";
	private static final String SELECT_EVENT_ITEM = "SELECT * FROM item WHERE event_id = ?";
	private static final String SELEC_ALL_ON_PAGE = "SELECT * FROM item ORDER BY item_id LIMIT ?,?";
	private static final String SELECT_COUNT = "SELECT count(item_id) FROM item";
	
	private class ItemRowMapper implements RowMapper
	{
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			Item item = new Item();
			item.setItemId(new Integer(rs.getInt(1)));
			item.setItemName(rs.getString(2));
			item.setPrice(new Integer(rs.getInt(3)));
			item.setDescription(rs.getString(4));
			item.setPictureUrl(rs.getString(5));
			
			return item;
		}
	}
	
	
	private class RsePageCount implements ResultSetExtractor
	{
		public Object extractData(ResultSet rs) throws SQLException, DataAccessException
		{
			if (rs.next()) {
				int numRec = rs.getInt(1);
				
				if (numRec % PAGE_SIZE == 0)
					return new Integer(rs.getInt(numRec % PAGE_SIZE));
				else
					return new Integer(rs.getInt(numRec % PAGE_SIZE + 1));
				
			}
			else
				return new Integer(0);
		}
	}
	
	
	public List findAll() {
		return getJdbcTemplate().query(ItemDaoImpl.SELECT_ALL, new ItemRowMapper());
	}
	
	private class ItemPreparedStatementSetterForSelectEventItem implements PreparedStatementCreator
	{
		private int eventId;
		
		public ItemPreparedStatementSetterForSelectEventItem(int eventId) {
			this.eventId = eventId;
		}

		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			PreparedStatement pstmt = con.prepareStatement(SELECT_EVENT_ITEM);
			pstmt.setInt(1, this.eventId);
			return pstmt;
		}
	}
	
	public class PstmtSetterForSelectPage implements PreparedStatementSetter
	{
		int page;
		
		public PstmtSetterForSelectPage(int page)
		{
			if (page > 0)
				this.page = page;
			else
				this.page = 1;
		}
		
		public void setValues(PreparedStatement pstmt) throws SQLException
		{
			pstmt.setInt(1, (page-1) * PAGE_SIZE );
			pstmt.setInt(2, page * PAGE_SIZE);
		}
	}
	
	public List findEvent(int index) {
		return getJdbcTemplate().query(new ItemPreparedStatementSetterForSelectEventItem(index), new ItemRowMapper());
	}
	
	public List getPage(int page) {
		return getJdbcTemplate().query(ItemDaoImpl.SELEC_ALL_ON_PAGE, new PstmtSetterForSelectPage(page), new ItemRowMapper());
	}
	
	public Integer getNumPage() {
		return (Integer) getJdbcTemplate().query(ItemDaoImpl.SELECT_COUNT, new RsePageCount());
	}
}

