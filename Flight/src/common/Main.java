package common;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"xml-config-1.xml");
		FlightRepository flight = (FlightRepository) ctx.getBean("flightRepo");
		List<Flight> fl = flight.getAvailableFlights();
		//System.out.println(flight.getAvailableFlights());
		for(Flight f : fl)
			System.out.println(f);
	}
}
