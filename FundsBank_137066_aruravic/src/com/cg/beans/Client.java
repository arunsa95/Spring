/**
 * 
 */
package com.cg.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author aruravic 
 * CREATE TABLE complaint(complaintid number primary key,
 *         accountid number,branchcode varchar2(20),emailid
 *         varchar2(20),category varchar2(20) ,description
 *         varchar2(300),priority varchar2(10),status varchar2(20));
 */
@Entity
@Table(name = "complaint")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private int complaintId;

	@NotNull(message = "Please Enter Account Id")
	private int accountId;

	@NotEmpty(message = "Please Enter Branch Code")
	private String branchCode;

	@NotEmpty(message = "Please Enter Mail id ")
	@Email
	private String emailId;
	
	@NotEmpty(message = "Please select category ")
	private String category;
	
	@NotEmpty(message = "Please Enter Description ")
	private String description;

	private String priority;
	private String status;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "Client [complaintId=" + complaintId + ", accountId="
				+ accountId + ", branchCode=" + branchCode + ", emailId="
				+ emailId + ", category=" + category + ", description="
				+ description + ", priority=" + priority + ", status=" + status
				+ "]";
	}

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
