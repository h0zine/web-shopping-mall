package store.dao;

import java.util.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.core.ResultSetExtractor;

import store.logic.Order;

public class OrderDaoImpl extends JdbcDaoSupport implements OrderDao 
{
	private static final String SELECT_ALL = "SELECT * FROM orders ORDER BY order_id ASC";
	private static final String SELECT_BY_INV  = "SELECT * FROM orders WHERE invoice_id = ?";
	private static final String SELECT_ODR = "SELECT * FROM orders WHERE order_id = ?";
	private static final String INSERT_ODR = "INSERT INTO orders (invoice_id, product_name, amount, price, status, create_date) "
										   + "VALUES (?,?,?,?,?,?)";
	private static final String DELETE_ODR = "DELETE FROM orders WHERE order_id = ?";
	private static final String DELETE_INV = "DELETE FROM orders WHERE invoice_id = ?";
	private static final String UPDATE_ODR = "UPDATE orders SET invoice_id = ?, product_name = ?, amount = ?, price = ?, "
		                                   + "                 status= ?, create_date = ? "
		                                   + "WHERE order_id = ?";
	
	public List  selectAll() {
		return getJdbcTemplate().query(SELECT_ALL, new RowMapperOdr());
	}
	
	public List  selectByInvoice(int invoiceId) {
		return getJdbcTemplate().query(SELECT_BY_INV, new Object[] {new Integer(invoiceId)}, new RowMapperOdr());
	}
	
	public Order selectOrder(int orderId) {
		return (Order) getJdbcTemplate().query(SELECT_ODR, new PstmtSetterOdr(orderId), new RseOrder());
	}
	
	public void  insert(Order order) {
		getJdbcTemplate().update(INSERT_ODR, new PstmtSetterInsert(order));
	}
	
	public void  delete(int orderId) {
		getJdbcTemplate().update(DELETE_ODR, new PstmtSetterDelOdr(orderId));
	}
	
	public void  deleteByInvoice(int invoiceId) {
		getJdbcTemplate().update(DELETE_INV, new PstmtSetterDelByInv(invoiceId));
	}
	
	public void  update(Order order) {
		getJdbcTemplate().update(UPDATE_ODR, new PstmtSetterUpdate(order));
	}
	
	private class RowMapperOdr implements RowMapper
	{
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			Order order = new Order();
			
			order.setAmount(rs.getInt("amount"));
			order.setCreateDate(new java.sql.Date(rs.getDate("create_date").getTime()));
			order.setInvoiceId(rs.getInt("invoice_id"));
			order.setOrderId(rs.getInt("order_id"));
			order.setPrice(rs.getString("price"));
			order.setProductName(rs.getString("product_name"));
			order.setStatus(rs.getString("status"));
			
			return order;
		}
	}

		
	private class PstmtSetterInv implements PreparedStatementSetter
	{
		private int invoiceId;
		
		public PstmtSetterInv(int invoiceId) {
			this.invoiceId = invoiceId;
		}
		
		public void setValues(PreparedStatement pstmt) throws SQLException {
			pstmt.setInt(1, invoiceId);
		}
		
	}
	
	private class RseOrder implements ResultSetExtractor
	{

		public Object extractData(ResultSet rs) throws SQLException, DataAccessException 
		{
			if (rs.next()) 
			{
				Order order = new Order();
				
				order.setAmount(rs.getInt("amount"));
				order.setCreateDate(new java.sql.Date(rs.getDate("create_date").getTime()));
				order.setInvoiceId(rs.getInt("invoice_id"));
				order.setOrderId(rs.getInt("order_id"));
				order.setPrice(rs.getString("price"));
				order.setProductName(rs.getString("product_name"));
				order.setStatus(rs.getString("status"));
				
				return order;
			}
			else 
				throw new DataRetrievalFailureException("Can't find the order.");
		}
		
	}
	
	private class PstmtSetterOdr implements PreparedStatementSetter
	{
		int orderId;
		public PstmtSetterOdr(int orderId) {
			this.orderId = orderId;
		}

		public void setValues(PreparedStatement pstmt) throws SQLException {
			pstmt.setInt(1, orderId);
		}
	}
	
	private class PstmtSetterInsert implements PreparedStatementSetter
	{
		private Order order;
		
		public PstmtSetterInsert(Order order) {
			this.order = order;
		}
		
		public void setValues(PreparedStatement pstmt) throws SQLException
		{
			pstmt.setInt(1, order.getInvoiceId());
			pstmt.setString(2, order.getProductName());
			pstmt.setInt(3, order.getAmount());
			pstmt.setString(4, order.getPrice());
			pstmt.setString(5, order.getStatus());
			pstmt.setDate(6, new java.sql.Date(order.getCreateDate().getTime()));
		}
	}
	
	private class PstmtSetterDelOdr implements PreparedStatementSetter
	{
		private int orderId;
		
		public PstmtSetterDelOdr(int orderId) {
			this.orderId = orderId;
		}
		
		public void setValues(PreparedStatement pstmt) throws SQLException {
			pstmt.setInt(1, orderId);
		}
	}
	
	private class PstmtSetterDelByInv implements PreparedStatementSetter
	{
		private int invoiceId;
		
		public PstmtSetterDelByInv(int invoiceId) {
			this.invoiceId = invoiceId;
		}
		
		public void setValues(PreparedStatement pstmt) throws SQLException {
			pstmt.setInt(1, invoiceId);
		}
		
	}
	
	private class PstmtSetterUpdate implements PreparedStatementSetter
	{
		private Order order;
		
		public PstmtSetterUpdate(Order order) {
			this.order = order;
		}
		
		public void setValues(PreparedStatement pstmt) throws SQLException
		{
            pstmt.setInt(1, order.getInvoiceId());
			pstmt.setString(2, order.getProductName());
			pstmt.setString(3, order.getPrice());
			pstmt.setString(4, order.getStatus());
			pstmt.setDate(5, new java.sql.Date(order.getCreateDate().getTime()));
			pstmt.setInt(6, order.getOrderId());
		}
	}
}
