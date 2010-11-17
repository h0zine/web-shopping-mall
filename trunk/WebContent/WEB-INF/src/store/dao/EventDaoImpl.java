package store.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import store.logic.Event;

public class EventDaoImpl extends JdbcDaoSupport implements EventDao
{
	private static final String SELECT_ALL = "SELECT event_id, event_name, event_order FROM event ORDER BY event_order";
	private static final String INSERT_NEW = "INSERT INTO event (event_name, event_order) VALUES (?, ?)";
	private static final String DELETE_BY_ID = "DELETE FROM event WHERE event_id = ?";
	private static final String SELECT_BY_ID = "SELECT * FROM event WHERE event_id = ?";
	private static final String UPDATE = "UPDATE event SET event_name = ?, event_order = ? WHERE event_id = ?";
	
	// Get a list of Event from result set
	private class EventRowMapper implements RowMapper
	{
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			Event event = new Event();
			event.setEventId(new Integer(rs.getInt(1)));
			event.setEventName(rs.getString(2));
			event.setEventOrder(new Integer(rs.getInt(3)));
			return event;
		}
	}
	
	private class PstmtSetterAdd implements PreparedStatementSetter
	{
		Event event;
		
		public PstmtSetterAdd(Event event) {
			this.event = event;
		}
		
		public void setValues(PreparedStatement pstmt) throws SQLException {
			pstmt.setString(1, event.getEventName());
			pstmt.setInt(2, event.getEventOrder().intValue());
		}
	}
	
	private class PstmtSetterDelete implements PreparedStatementSetter
	{
		int id;
		
		public PstmtSetterDelete(int id) {
			this.id = id;
		}
		
		public void setValues(PreparedStatement pstmt) throws SQLException {
			pstmt.setInt(1, id);
		}
	}
	
	private class PstmtSetterSelectById implements PreparedStatementSetter
	{
		int id;
		
		public PstmtSetterSelectById(int id) {
			this.id = id;
		}
		
		public void setValues(PreparedStatement pstmt) throws SQLException {
			pstmt.setInt(1, id);
		}
	}
	
	private class RseEvent implements ResultSetExtractor
	{
		public Object extractData(ResultSet rs) throws SQLException, DataAccessException
		{
			if (rs.next()) 
			{
				Event event = new Event();
				
				event.setEventId(new Integer(rs.getInt("event_id")));
				event.setEventName(rs.getString("event_name"));
				event.setEventOrder(new Integer(rs.getInt("event_order")));
				
				return event;
			}
			else 
				throw new DataRetrievalFailureException("Can't find the event.");
		}
	}
	
	private class PstmtSetterUpdate implements PreparedStatementSetter
	{
		Event event;
		public PstmtSetterUpdate(Event event) {
			this.event = event;
		}
		
		public void setValues(PreparedStatement pstmt) throws SQLException {
			pstmt.setString(1, event.getEventName());
			pstmt.setInt(2, event.getEventOrder().intValue());
			pstmt.setInt(3, event.getEventId().intValue());
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Event> findAllEvent() {
		return getJdbcTemplate().query(EventDaoImpl.SELECT_ALL, new EventRowMapper());
	}

	public void add(Event event) {
		getJdbcTemplate().update(EventDaoImpl.INSERT_NEW, new PstmtSetterAdd(event));
	}
	
	public void delete(int id) {
		getJdbcTemplate().update(EventDaoImpl.DELETE_BY_ID, new PstmtSetterDelete(id));
	}
	
	public Event get(int id) {
		return (Event) getJdbcTemplate().query(EventDaoImpl.SELECT_BY_ID, new PstmtSetterSelectById(id), new RseEvent()); 
	}
	
	public void update(Event event) {
		getJdbcTemplate().update(EventDaoImpl.UPDATE, new PstmtSetterUpdate(event));
	}
}
