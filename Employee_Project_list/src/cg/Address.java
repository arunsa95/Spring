/**
 * 
 */
package cg;

import java.util.List;

/**
 * @author aruravic
 *
 */
// @Component
public class Address {

	private List<Object> lists;
	// @Value("mumbai")
	private String city;
	// @Value("maharastra")
	private String state;
	// @Value("710020")
	private int pincode;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", pincode="
				+ pincode + "]";
	}

	public Address(String city, String state, int pincode) {
		super();
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

}
