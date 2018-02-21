package hibernate.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Trans")
public class Transaction {
	
	@Id
	@GeneratedValue @Column(name="Trans_ID")
	private long transactionId;
	@Column(name="Trans_Type")
	private String transactionType;
	@Column(name="Trans_Date")
	private Date transactionDate;
	@Column(name="Trans_amt")
	private double amount;
	private Account account;
	
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(512);
		sb.append("\n----TRANSACTION DETAILS----\n");
		sb.append("transactionId=" + transactionId + "\n");
		sb.append("transactionType=" + transactionType + "\n");
		sb.append("transactionDate=" + transactionDate + "\n");
		sb.append("amount=" + amount + "\n");
		sb.append("Account=" + account + "\n");
		sb.append("----TRANSACTION DETAILS----\n");
		return sb.toString();
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
