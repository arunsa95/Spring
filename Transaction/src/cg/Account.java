/**
 * 
 */
package cg;

/**
 * @author aruravic
 *
 */
public class Account {

	private String number;
	private Double balance;
	public Account() {
		
	}
	
	public Account(String number, Double balance) {
		super();
		this.number = number;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [number=" + number + ", balance=" + balance + "]";
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public void debit(Double debitAmount){ 
	this.balance = this.balance - debitAmount;
	}
	public void credit(Double creditAmount) {
	this.balance = this.balance + creditAmount;
	}

}
