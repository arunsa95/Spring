/**
 * 
 */
package cg;

/**
 * @author aruravic
 *
 */
// @Component("empl")
public class Employee {
	// @Autowired
	private Address addr;
	// @Value("xyz")
	private String name;
	// @Value("12345")
	private double salary;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [addr=" + addr + ", name=" + name + ", salary="
				+ salary + "]";
	}

	public Employee(Address addr, String name, double salary) {
		super();
		this.addr = addr;
		this.name = name;
		this.salary = salary;
	}

}
