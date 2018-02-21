package hibernate.vo;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Domain object representing an Account
 */
@Entity
@Table(name="Accounts")
public class Account {
	public static final String ACCOUNT_TYPE_SAVINGS = "SAVINGS";
	public static final String ACCOUNT_TYPE_CHECKING = "CHECKING";
	@Id
	@GeneratedValue @Column(name="Acc_ID")
	private long accountId;
	@Column(name="account_Type")
	private String accountType;
	@Column(name="Creat_Date")
	private Date creationDate;
	@Column(name="BAl")
	private double balance;
	private Set<Transaction> transactions;

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	/**
	 * Get accountId
	 * 
	 * @return accountId
	 */
	public long getAccountId() {
		return accountId;
	}

	/**
	 * Set accountId
	 * 
	 * @param accountId
	 */
	@SuppressWarnings("unused")
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	/**
	 * Get accountType
	 * 
	 * @return accountType
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * Set accountType
	 * 
	 * @param accountType
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	/**
	 * Get creationDate
	 * 
	 * @return creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * Set creationDate
	 * 
	 * @param creationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Get balance
	 * 
	 * @return balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Set balance
	 * 
	 * @param balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountId ^ (accountId >>> 32));
		result = prime * result
				+ ((accountType == null) ? 0 : accountType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((creationDate == null) ? 0 : creationDate.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountType="
				+ accountType + ", creationDate=" + creationDate + ", balance="
				+ balance;// + ", transactions=" + transactions + "]";
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Account))
			return false;
		Account other = (Account) obj;
		if (accountId != other.accountId)
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (Double.doubleToLongBits(balance) != Double
				.doubleToLongBits(other.balance))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		return true;
	}
}
