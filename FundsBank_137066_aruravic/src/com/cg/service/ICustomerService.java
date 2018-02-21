/**
 * 
 */
package com.cg.service;

import java.util.List;

import com.cg.beans.Client;

/**
 * @author aruravic
 *
 */
public interface ICustomerService {

	public Client getComplaintDetails(int complaintId);
	public List<Client> getAllComplaintDetails();
	public Client addComplaintDetails(Client client);
}
