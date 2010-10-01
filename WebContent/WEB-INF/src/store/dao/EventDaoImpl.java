package store.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import store.logic.Event;

public class EventDaoImpl extends JdbcDaoSupport implements EventDao
{
	private static final String SELECT_ALL = "SELECT event_id, event_name, event_order FROM event ORDER BY event_order";

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

	public List findAllEvent()
	{
		return getJdbcTemplate().query(EventDaoImpl.SELECT_ALL, new EventRowMapper());
	}
}
