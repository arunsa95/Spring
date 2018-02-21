package xml;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import common.Flight;
import common.FlightRepository;

public class FlightRepositoryImpl implements FlightRepository {

	// private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List getFlights(String carrier) {

		return jdbcTemplate.queryForList(
				"select * from flights_test where carrier=?", carrier);

	}

	

	@Override
	public void newUpdateFlight(Flight flight) {
		jdbcTemplate.update("INSERT INTO flights_test VALUES(?,?,?,?)",
				flight.getFlightNo(), flight.getCarrier(), flight.getFrom(),
				flight.getTo());

	}

	
	
	public Flight getFlight(String flightno)
	{
	class FlightMapper implements RowMapper<Flight> {
	@Override
	public Flight mapRow(ResultSet rs, int index) throws SQLException {
		Flight flight = new Flight();
		flight.setFlightNo(rs.getString(1));
		flight.setCarrier(rs.getString(2));
		flight.setFrom(rs.getString(3));
		flight.setTo(rs.getString(4));
		return flight;
		}

	
	}
Flight flight = jdbcTemplate.queryForObject("select * from flights_test where flightno=? ", new Object[]{flightno}, new FlightMapper());
		return flight;
}

	

}
