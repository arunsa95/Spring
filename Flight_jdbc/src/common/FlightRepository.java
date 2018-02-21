package common;

import java.util.List;
import java.util.Map;

public interface FlightRepository {

	

	public Flight getFlight(String flightno);
	public void newUpdateFlight(Flight flight);
	 public List getFlights(String carrier);
	// public void newFlight(Flight flight) ;
}
