package store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;

import store.logic.Category;

public class CategoryDaoImpl extends JdbcDaoSupport implements CategoryDao 
{
	private static final String SELECT_ALL_PARENT = "SELECT category_id, category_name, category_depth, category_parent, category_thread, category_order FROM category WHERE category_parent = ? ORDER BY category_thread, category_order";
	private static final String SELECT_ALL        = "SELECT category_id, category_name, category_depth, category_parent, category_thread, category_order FROM category ORDER BY category_thread, category_order";
	private static final String INSERT_CATEGORY   = "INSERT INTO category (category_name, category_depth, category_parent, category_thread, category_order) VALUES (?,?,?,?,?)";
	private static final String DELETE_CATEGORY   = "DELETE FROM category WHERE category_id = ?"; 
	private static final String SELECT_CATEGORY   = "SELECT * FROM category WHERE category_id = ?";
	private static final String UPDATE_CATEGORY   = "UPDATE category SET category_name = ? WHERE category_id = ?";
	private static final String MAKE_SPACE        = "UPDATE category SET category_order = category_order + 1 WHERE category_thread = ? AND category_order > ?";
	private static final String SET_THREAD        = "UPDATE category SET category_thread = category_id WHERE category_thread = 0";
	private static final String SELECT_DESCENDANT =
		"SELECT * FROM category WHERE category_thread = ? ORDER BY category_thread, category_order";
	private static final String SELECT_PATH       = "SELECT c1.* FROM category c1, category c2 WHERE c1.category_thread = c2.category_thread AND c2.category_id = ? AND c1.category_order <= c2.category_order ORDER BY c1.category_order ASC";
	
	private class CategoryRowMapper implements RowMapper
	{
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			// Populate Category from result set.
			Category category = new Category();
			category.setDepth(new Integer(rs.getInt("category_depth")));
			category.setId(new Integer(rs.getInt("category_id")));
			category.setName(rs.getString("category_name"));
			category.setParent(new Integer(rs.getInt("category_parent")));
			category.setThread(new Integer(rs.getInt("category_thread")));
			category.setOrder(new Integer(rs.getInt("category_order")));
			return category;
		}
	}
	
	private class CategoryResultSetExtractor implements ResultSetExtractor
	{
		public Object extractData(ResultSet rs) throws SQLException, DataAccessException
		{
			if (rs.next()) 
			{
				Category category = new Category();
				category.setDepth(new Integer(rs.getInt("category_depth")));
				category.setId(new Integer(rs.getInt("category_id")));
				category.setName(rs.getString("category_name"));
				category.setParent(new Integer(rs.getInt("category_parent")));
				category.setThread(new Integer(rs.getInt("category_thread")));
				category.setOrder(new Integer(rs.getInt("category_order")));
				return category;
			}
			else 
				throw new DataRetrievalFailureException("Can't find the category.");
		}
	}

	private class PreparedStatementSetterForSelectAllCategory implements PreparedStatementCreator
	{
		private int parent;
		
		public PreparedStatementSetterForSelectAllCategory(int parent) {
			this.parent = parent;
		}

		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			PreparedStatement pstmt = con.prepareStatement(SELECT_ALL_PARENT);
			pstmt.setInt(1, this.parent);
			return pstmt;
		}
	}

	private class PreparedStatementSetterForInsertCategory implements PreparedStatementSetter
	{
		private Category category;
		
		public PreparedStatementSetterForInsertCategory(Category category) {
			this.category = category;
		}

		public void setValues(PreparedStatement pstmt) throws SQLException {
			pstmt.setString(1, this.category.getName());
			pstmt.setInt(2, this.category.getDepth().intValue());
			pstmt.setInt(3, this.category.getParent().intValue());
			pstmt.setInt(4, this.category.getThread().intValue());
			pstmt.setInt(5, this.category.getOrder().intValue());
		}
	}
	
	private class PstmtSetterForUpdateCategory implements PreparedStatementSetter
	{
		private Category category;
		
		public PstmtSetterForUpdateCategory(Category category) {
			this.category = category;
		}

		public void setValues(PreparedStatement pstmt) throws SQLException {
			pstmt.setString(1, this.category.getName());
			pstmt.setInt(2, this.category.getId().intValue());
		}
	}
	
	private class PstmtSetterForSelectCategory implements PreparedStatementSetter
	{
		private int id;
		
		public PstmtSetterForSelectCategory(int id) {
			this.id = id;
		}
		
		public void setValues(PreparedStatement pstmt) throws SQLException {
			pstmt.setInt(1, this.id);
		}
	}
	

	private class PreparedStatementSetterForDeleteCategory implements PreparedStatementSetter
	{
		private int id;
		
		public PreparedStatementSetterForDeleteCategory(int id) {
			this.id = id;
		}

		public void setValues(PreparedStatement pstmt) throws SQLException {
			pstmt.setInt(1, this.id);
		}
	}
	
	private class PstmtSetterForMakeSpace implements PreparedStatementSetter
	{
		Category category;
		
		public PstmtSetterForMakeSpace(Category category) {
			this.category = category;
		}
		
		public void setValues(PreparedStatement pstmt) throws SQLException {
			pstmt.setInt(1, category.getThread().intValue());
			pstmt.setInt(2, category.getOrder().intValue());
		}
	}
	
	/**
	 * This retrieve top level category
	 */
	public List findAllCategory() {
		return getJdbcTemplate().query(CategoryDaoImpl.SELECT_ALL, new CategoryRowMapper());
	}
	
	public List findAllCategory(int parent)
	{
		return getJdbcTemplate().query(new PreparedStatementSetterForSelectAllCategory(parent), new CategoryRowMapper());
	}

	public void entry(Category category)
	{
		if (category.getParent().intValue() > 0) {
			Category parent = (Category) getJdbcTemplate().query(CategoryDaoImpl.SELECT_CATEGORY, new PstmtSetterForSelectCategory(category.getParent().intValue()), new CategoryResultSetExtractor());
			getJdbcTemplate().update(CategoryDaoImpl.MAKE_SPACE, new PstmtSetterForMakeSpace(parent));
			category.setDepth(new Integer(parent.getDepth().intValue()+1));
			category.setThread(parent.getThread());
			category.setOrder(new Integer(parent.getOrder().intValue()+1));
			getJdbcTemplate().update(CategoryDaoImpl.INSERT_CATEGORY, new PreparedStatementSetterForInsertCategory(category));
		}
		else {
			getJdbcTemplate().update(CategoryDaoImpl.INSERT_CATEGORY, new PreparedStatementSetterForInsertCategory(category));
			getJdbcTemplate().update(CategoryDaoImpl.SET_THREAD);
		}
	}
	
	public void delete(int id) {
		getJdbcTemplate().update(CategoryDaoImpl.DELETE_CATEGORY, new PreparedStatementSetterForDeleteCategory(id));
	}

	public Category get(int id) {
		return (Category) getJdbcTemplate().query(CategoryDaoImpl.SELECT_CATEGORY, new Object[] { new Integer(id) }, new CategoryResultSetExtractor());
	}

	public void update(Category category) {
		getJdbcTemplate().update(CategoryDaoImpl.UPDATE_CATEGORY, new PstmtSetterForUpdateCategory(category));
	}


	public List findAllDescendant(int parentId) {
		Category ca = get(parentId);
		List descendants = getJdbcTemplate().query(SELECT_DESCENDANT, new Object[] { ca.getThread() } , new CategoryRowMapper());
		
		ArrayList list = new ArrayList();
		list.add(ca);


		int i = 0;
		Category de = (Category) descendants.get(i);
		while (de.getOrder().intValue() != ca.getOrder().intValue() && i < descendants.size()) {
			i ++;
			de = (Category) descendants.get(i);
		}

		// get items for descendant category
		while (i < descendants.size()) {	
			de = (Category) descendants.get(i);
			if (de.getDepth().intValue() > ca.getDepth().intValue())
				list.add(de);
			i++;
		}
		
		// remove duplicate;
		for (int j = 0; j < list.size(); j++) {
			int caId = ((Category) list.get(j)).getId().intValue();
			
			int k = j + 1;
			for (; k < list.size(); k++) {
				if (caId == ((Category) list.get(k)).getId().intValue()) {
					((Category) list.get(k)).setId(new Integer(0));
				}
			}
		}
		
		return list; 
	}
	
	public List getPath(int category) {
		return getJdbcTemplate().query(SELECT_PATH, new Object[] { new Integer(category)}, new CategoryRowMapper());
	}
}
