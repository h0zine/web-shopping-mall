package store.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import store.logic.Invoice;


public class InvoiceDaoImpl extends JdbcDaoSupport implements InvoiceDao {
	private final static int PAGE_SIZE = 30;
	private final static String SELECT_PAGE = "SELECT * FROM invoice ORDER BY invoice_id LIMIT ?,?";
	private final static String SELECT_INVOICE = "SELECT * FROM invoice WHERE invoice_id = ?";
	private final static String UPDATE_INVOICE = 
		"UPDATE invoice SET issue_date=?, last_update=?, buyer_id=?, buyer_name=?, buyer_email=?," +
		"buyer_phone=?, receiver_name=?, receiver_email=?, receiver_phone=?, postcode=?," +
		"address1=?, address2=?, state=?, country=?, product_cost=?, delivery_cost=?, paymethod=?," +
		"status=?, memo=? WHERE invoice_id = ?";

	private class RMInvoice implements RowMapper {

		public Object mapRow(ResultSet rs, int rownum) throws SQLException {
			Invoice invoice = new Invoice();
			
			invoice.setId(rs.getInt("invoice_id"));
			
			invoice.setIssueDate(new java.sql.Date(rs.getDate("issue_date").getTime()));
			invoice.setLastUpdate(new java.sql.Date(rs.getDate("last_update").getTime()));

			invoice.setBuyerId(rs.getString("buyer_id"));

			invoice.setBuyerName(rs.getString("buyer_name"));
			invoice.setBuyerEmail(rs.getString("buyer_email"));
			invoice.setBuyerPhone(rs.getString("buyer_phone"));

			invoice.setReceiverName(rs.getString("receiver_name"));
			invoice.setReceiverEmail(rs.getString("receiver_email"));
			invoice.setReceiverPhone(rs.getString("receiver_phone"));

			invoice.setPostcode(rs.getString("postcode"));
			invoice.setAddress1(rs.getString("address1"));
			invoice.setAddress2(rs.getString("address2"));
			invoice.setState(rs.getString("state"));
			invoice.setCountry(rs.getString("country"));

			invoice.setProductCost(rs.getString("product_cost"));
			invoice.setDeliveryCost(rs.getString("delivery_cost"));
			invoice.setPaymethod(rs.getString("paymethod"));
			invoice.setStatus(rs.getString("status"));
			invoice.setMemo(rs.getString("memo"));
			
			return invoice;
		}
	}
	
	private class RseInvoice implements ResultSetExtractor {

		public Object extractData(ResultSet rs) throws SQLException,
				DataAccessException {
			if (rs.next()) {
				Invoice invoice = new Invoice();
				
				invoice.setId(rs.getInt("invoice_id"));
				
				invoice.setIssueDate(new java.sql.Date(rs.getDate("issue_date").getTime()));
				invoice.setLastUpdate(new java.sql.Date(rs.getDate("last_update").getTime()));
	
				invoice.setBuyerId(rs.getString("buyer_id"));
	
				invoice.setBuyerName(rs.getString("buyer_name"));
				invoice.setBuyerEmail(rs.getString("buyer_email"));
				invoice.setBuyerPhone(rs.getString("buyer_phone"));
	
				invoice.setReceiverName(rs.getString("receiver_name"));
				invoice.setReceiverEmail(rs.getString("receiver_email"));
				invoice.setReceiverPhone(rs.getString("receiver_phone"));
	
				invoice.setPostcode(rs.getString("postcode"));
				invoice.setAddress1(rs.getString("address1"));
				invoice.setAddress2(rs.getString("address2"));
				invoice.setState(rs.getString("state"));
				invoice.setCountry(rs.getString("country"));
	
				invoice.setProductCost(rs.getString("product_cost"));
				invoice.setDeliveryCost(rs.getString("delivery_cost"));
				invoice.setPaymethod(rs.getString("paymethod"));
				invoice.setStatus(rs.getString("status"));
				invoice.setMemo(rs.getString("memo"));
				
				return invoice;
			}
			else {
				throw new DataRetrievalFailureException("Can't find the invoice.");
			}
		}
		
	}
	
	private class PstmtSetterUpdateInvoice implements PreparedStatementSetter {
		private Invoice invoice;
		
		public PstmtSetterUpdateInvoice(Invoice invoice)
		{
			this.invoice = invoice;
		}

		public void setValues(PreparedStatement pstmt) throws SQLException {
			pstmt.setDate(1, new java.sql.Date(invoice.getIssueDate().getTime()));
			pstmt.setDate(2, new java.sql.Date(invoice.getLastUpdate().getTime()));
			pstmt.setString(3, invoice.getBuyerId());
			pstmt.setString(4, invoice.getBuyerName());
			pstmt.setString(5, invoice.getBuyerEmail());
			pstmt.setString(6, invoice.getBuyerPhone());
			pstmt.setString(7, invoice.getReceiverName());
			pstmt.setString(8, invoice.getReceiverEmail());
			pstmt.setString(9, invoice.getReceiverPhone());
			pstmt.setString(10, invoice.getPostcode());
			pstmt.setString(11, invoice.getAddress1());
			pstmt.setString(12, invoice.getAddress2());
			pstmt.setString(13, invoice.getState());
			pstmt.setString(14, invoice.getCountry()); 
			pstmt.setString(15, invoice.getProductCost());
			pstmt.setString(16, invoice.getDeliveryCost());
			pstmt.setString(17, invoice.getPaymethod());
			pstmt.setString(18, invoice.getStatus());
			pstmt.setString(19, invoice.getMemo());
			pstmt.setInt(20, invoice. getId());
		
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Invoice> getPage(int pagenum) {
		if (pagenum <= 0) 
			pagenum = 1;
		
		int start = PAGE_SIZE * (pagenum - 1), end = PAGE_SIZE * pagenum;
		return getJdbcTemplate().query(SELECT_PAGE, new Object[] {new Integer(start), new Integer(end)}, new RMInvoice());
	}
	
	public Invoice getInvoice(int invoiceId) {
		return (Invoice) getJdbcTemplate().query(SELECT_INVOICE, new Object[] {new Integer(invoiceId)}, new RseInvoice());
	}
	
	public void updateInvoice(Invoice invoice) {
		getJdbcTemplate().update(UPDATE_INVOICE, new PstmtSetterUpdateInvoice(invoice));
	}
	
	class RsGetEmptyInvoice implements ResultSetExtractor 
	{
		@Override
		public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
			
			if (rs.next()) {
				Invoice invoice = new Invoice();
				invoice.setId(rs.getInt("id"));
				invoice.setIssueDate(new java.util.Date());
				invoice.setLastUpdate(new java.util.Date());
			
				return invoice;
			} 
			else {
				throw new SQLException("LAST_INSERT_ID() doesn't work.");
			}
		}
	} 
	
	public Invoice createInvoice() {
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		getJdbcTemplate().update("INSERT INTO invoice (issue_date, last_update) VALUES(?,?)", new Object[] {now, now});
		return (Invoice) getJdbcTemplate().query("SELECT MAX(invoice_id) as id FROM invoice", new RsGetEmptyInvoice());
	}
	
	@SuppressWarnings("unchecked")
	public List<Invoice> findAll(String email, String id)  {
		return getJdbcTemplate().query("SELECT * FROM invoice WHERE buyer_email = ? AND buyer_id = ? LIMIT 1,100",
				new Object[] {email, id}, new RMInvoice());
	}
}
