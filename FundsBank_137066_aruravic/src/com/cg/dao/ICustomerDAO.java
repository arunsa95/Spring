/**
 * 
 */
package com.cg.dao;

import java.util.List;

import com.cg.beans.Client;

/**
 * @author aruravic
 *
 */
public interface ICustomerDAO {

	public Client getComplaintDetails(int complaintId);
	public List<Client> getAllComplaintDetails(); 
	public Client addComplaintDetails(Client client);
}
