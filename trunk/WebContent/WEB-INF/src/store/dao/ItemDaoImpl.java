package store.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.dao.DataRetrievalFailureException;

import store.logic.Item;

public class ItemDaoImpl extends JdbcDaoSupport implements ItemDao {

	protected static final int PAGE_SIZE = 30;
	
	private static final String SELECT_ALL = "SELECT * FROM item";
	private static final String SELECT_EVENT_ITEM = "SELECT * FROM item WHERE event_id_1 = ? OR event_id_2 = ? OR event_id_3 = ?";
	private static final String SELEC_ALL_ON_PAGE = "SELECT * FROM item ORDER BY item_id LIMIT ?,?";
	private static final String SELECT_COUNT = "SELECT count(item_id) FROM item";
	private static final String INSERT_ITEM =
		"INSERT INTO item (item_name, price, description, picture_url, visit, sold, amount, " +
		"last_sold, last_visit, last_update, category_id_1, category_id_2, category_id_3, " +
		"event_id_1, event_id_2, event_id_3) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String DELETE_ITEM = "DELETE FROM item WHERE item_id = ?";
	private static final String UPDATE_ITEM =
		"UPDATE item SET item_name=?, price=?, description=?, picture_url=?, visit=?, sold=?, amount=?, " +
		"last_sold=?, last_visit=?, last_update=?, category_id_1=?, category_id_2=?, category_id_3=?, " +
		"event_id_1=?, event_id_2=?, event_id_3=? WHERE item_id = ?";
	private static final String GET_ITEM = "SELECT * FROM item WHERE item_id = ?";
	private static final String GET_ITEM_BY_CATEGORY = "SELECT * FROM item WHERE category_id_1 = ? OR category_id_2 = ? OR category_id_3 = ?";
	
	private class ItemRowMapper implements RowMapper
	{
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			Item item = new Item();
			
			item.setItemId(new Integer(rs.getInt("item_id")));
			item.setItemName(rs.getString("item_name"));
			item.setPrice(new Integer(rs.getInt("price")));
			item.setDescription(rs.getString("description"));
			item.setPictureUrl(rs.getString("picture_url"));
			item.setVisit(new Integer(rs.getInt("visit")));
			item.setSold(new Integer(rs.getInt("sold")));
			item.setAmount(new Integer(rs.getInt("amount")));
			item.setLastSold(new java.util.Date(rs.getDate("last_sold").getTime()));
			item.setLastVisit(new java.util.Date(rs.getDate("last_visit").getTime()));
			item.setLastUpdate(new java.util.Date(rs.getDate("last_update").getTime()));
			item.setCategoryId1(new Integer(rs.getInt("category_id_1")));
			item.setCategoryId2(new Integer(rs.getInt("category_id_2")));
			item.setCategoryId3(new Integer(rs.getInt("category_id_3")));
			item.setEventId1(new Integer(rs.getInt("event_id_1")));
			item.setEventId2(new Integer(rs.getInt("event_id_2")));
			item.setEventId3(new Integer(rs.getInt("event_id_3")));
		
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
					return new Integer(numRec % PAGE_SIZE);
				else
					return new Integer(numRec % PAGE_SIZE + 1);
				
			}
			else
				return new Integer(0);
		}
	}

	private class RsItem implements ResultSetExtractor
	{
		public Object extractData(ResultSet rs) throws SQLException, DataAccessException
		{
			if (rs.next()) {
				Item item = new Item();
				
				item.setItemId(new Integer(rs.getInt("item_id")));
				item.setItemName(rs.getString("item_name"));
				item.setPrice(new Integer(rs.getInt("price")));
				item.setDescription(rs.getString("description"));
				item.setPictureUrl(rs.getString("picture_url"));
				item.setVisit(new Integer(rs.getInt("visit")));
				item.setSold(new Integer(rs.getInt("sold")));
				item.setAmount(new Integer(rs.getInt("amount")));
				item.setLastSold(new java.util.Date(rs.getDate("last_sold").getTime()));
				item.setLastVisit(new java.util.Date(rs.getDate("last_visit").getTime()));
				item.setLastUpdate(new java.util.Date(rs.getDate("last_update").getTime()));
				item.setCategoryId1(new Integer(rs.getInt("category_id_1")));
				item.setCategoryId2(new Integer(rs.getInt("category_id_2")));
				item.setCategoryId3(new Integer(rs.getInt("category_id_3")));
				item.setEventId1(new Integer(rs.getInt("event_id_1")));
				item.setEventId2(new Integer(rs.getInt("event_id_2")));
				item.setEventId3(new Integer(rs.getInt("event_id_3")));
			
				return item;
			}
			else
				throw new DataRetrievalFailureException("Item data is not available.");
		}
	}


	private class PstmtSetterInsertItem implements PreparedStatementSetter
	{
		Item item;
		
		public PstmtSetterInsertItem(Item item) {
			this.item = item;
		}
		
		public void setValues(PreparedStatement pstmt) throws SQLException
		{
			pstmt.setString(1,item.getItemName());
			pstmt.setInt(2, item.getPrice().intValue());
			pstmt.setString(3, item.getDescription());
			pstmt.setString(4, item.getPictureUrl());
			pstmt.setInt(5, item.getVisit().intValue());
			pstmt.setInt(6, item.getSold().intValue());
			pstmt.setInt(7, item.getAmount().intValue());
			pstmt.setDate(8, new java.sql.Date(item.getLastSold().getTime()));
			pstmt.setDate(9, new java.sql.Date(item.getLastVisit().getTime()));
			pstmt.setDate(10, new java.sql.Date(item.getLastUpdate().getTime()));
			pstmt.setInt(11, item.getCategoryId1().intValue());
			pstmt.setInt(12, item.getCategoryId2().intValue());
			pstmt.setInt(13, item.getCategoryId3().intValue());
			pstmt.setInt(14, item.getEventId1().intValue());
			pstmt.setInt(15, item.getEventId2().intValue());
			pstmt.setInt(16, item.getEventId3().intValue());
		}
	}
	
	private class PstmtSetterDeleteItem implements PreparedStatementSetter
	{
		int item_id;
		
		public PstmtSetterDeleteItem(int item_id) {
			this.item_id = item_id;
		}
		
		public void setValues(PreparedStatement pstmt) throws SQLException
		{
			pstmt.setInt(1, item_id);
		}
	}
	
	private class PstmtSetterUpdateItem implements PreparedStatementSetter
	{
		Item item;
		
		public PstmtSetterUpdateItem(Item item) {
			this.item = item;
		}

		public void setValues(PreparedStatement pstmt) throws SQLException {
			pstmt.setString(1,item.getItemName());
			pstmt.setInt(2, item.getPrice().intValue());
			pstmt.setString(3, item.getDescription());
			pstmt.setString(4, item.getPictureUrl());
			pstmt.setInt(5, item.getVisit().intValue());
			pstmt.setInt(6, item.getSold().intValue());
			pstmt.setInt(7, item.getAmount().intValue());
			pstmt.setDate(8, new java.sql.Date(item.getLastSold().getTime()));
			pstmt.setDate(9, new java.sql.Date(item.getLastVisit().getTime()));
			pstmt.setDate(10, new java.sql.Date(item.getLastUpdate().getTime()));
			pstmt.setInt(11, item.getCategoryId1().intValue());
			pstmt.setInt(12, item.getCategoryId2().intValue());
			pstmt.setInt(13, item.getCategoryId3().intValue());
			pstmt.setInt(14, item.getEventId1().intValue());
			pstmt.setInt(15, item.getEventId2().intValue());
			pstmt.setInt(16, item.getEventId3().intValue());
			pstmt.setInt(17, item.getItemId().intValue());
		}
	}
	
	private class PstmtSetterGetItem implements PreparedStatementSetter
	{
		private int id;
		
		public PstmtSetterGetItem(int id) {
			this.id = id;
		}
		
		public void setValues(PreparedStatement pstmt) throws SQLException {
			pstmt.setInt(1, id);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Item> findAll() {
		return getJdbcTemplate().query(ItemDaoImpl.SELECT_ALL, new ItemRowMapper());
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
	
	@SuppressWarnings("unchecked")
	public List<Item> findEvent(int index) {
		return getJdbcTemplate().query(SELECT_EVENT_ITEM, new Object[] { new Integer(index),new Integer(index),new Integer(index) }, new ItemRowMapper());
	}
	
	@SuppressWarnings("unchecked")
	public List<Item> getPage(int page) {
		return getJdbcTemplate().query(ItemDaoImpl.SELEC_ALL_ON_PAGE, new PstmtSetterForSelectPage(page), new ItemRowMapper());
	}
	
	public Integer getNumPage() {
		return (Integer) getJdbcTemplate().query(ItemDaoImpl.SELECT_COUNT, new RsePageCount());
	}

	public void entry(Item item) {
		getJdbcTemplate().update(ItemDaoImpl.INSERT_ITEM, new PstmtSetterInsertItem(item));
	}
	
	public void delete(int id) {
		getJdbcTemplate().update(ItemDaoImpl.DELETE_ITEM, new PstmtSetterDeleteItem(id));
	}
	
	public void update(Item item) {
		try {
			getJdbcTemplate().update(ItemDaoImpl.UPDATE_ITEM, new PstmtSetterUpdateItem(item));
		}
		catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
	
	public Item get(int id) {
		return (Item) getJdbcTemplate().query(ItemDaoImpl.GET_ITEM, new PstmtSetterGetItem(id), new RsItem());
	}
	
	@SuppressWarnings("unchecked")
	public List<Item> getByCategory(int category) {
		Integer ca = new Integer(category);
		return getJdbcTemplate().query(ItemDaoImpl.GET_ITEM_BY_CATEGORY,  new Object[] { ca, ca, ca },  new ItemRowMapper());
	}
}

