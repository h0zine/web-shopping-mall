package store.dao;

import java.util.Date;
import java.util.List;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import store.logic.Order;

public class OrderDaoImpl extends JdbcDaoSupport implements OrderDao 
{
	private static final String SELECT_ALL = "SELECT * FROM order ORDER BY order_id ASC";
	private static final String SELEC_BY_INV  = "SELECT * FROM order WHERE invoice_id = ?";
	private static final String SELECT_ODR = "SELECT * FROM order WHERE order_id = ?";
	private static final String INSERT_ODR = "INSERT INTO order (invoice_id, product_name, amount, price, status, create_date) "
										   + "VALUES (?,?,?,?,?,?)";
	private static final String DELETE_ODR = "DELETE FROM order WHERE order_id = ?";
	private static final String DELETE_INV = "DELETE FROM order WHERE invoice_id = ?";
	private static final String UPDATE_ODR = "UPDATE order SET invoice_id = ?, product_name = ?, amount = ?, price = ?, "
		                                   + "                 status= ?, create_date = ? "
		                                   + "WHERE order_id = ?";
	
	private int id;
	private String productName;
	private int amount;
	private String price;
	private String status;   // waiting pay, payed, preparing, waiting pickup, sent, returned, withdrawn
	private Date createDate;
	private List options;
	
	public List  selectAll() {
		return null;
	}
	
	public List  selectByInvoice(int invoiceId) {
		return null;
	}
	
	public Order selectOrder(int orderId) {
		return null;
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
	
	
	private class PstmtSetterInsert implements PreparedStatementSetter
	{
		private Order order;
		
		public PstmtSetterInsert(Order order) {
			this.order = order;
		}
		
		public void setValues(PreparedStatement pstmt) throws SQLException
		{
			
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
