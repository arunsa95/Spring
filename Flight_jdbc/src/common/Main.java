package common;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"annotations-config-1.xml");
		FlightRepository flight = (FlightRepository) ctx.getBean("flightRepo");
		/*Scanner sc = new Scanner(System.in);
		System.out.println("Enter carrier Name: ");
		String carrier=sc.nextLine();
		List fli =flight.getFlights(carrier);
		System.out.println(fli);*/
		
		System.out.println("Enter Flight No. To be updated :");
		Scanner sc = new Scanner(System.in);
		String flightno=sc.nextLine();
		 flight.getFlight(flightno);
		Flight f = new Flight();
		//flight1.getFlight(flightno);
		
		f.setFlightNo("MI-125");
		f.setCarrier("MICROICE");
		f.setFrom("MUMBAI");
		f.setTo("BENGALURU");
		
		flight.newUpdateFlight(f);
		
		
		
		
	}
}
