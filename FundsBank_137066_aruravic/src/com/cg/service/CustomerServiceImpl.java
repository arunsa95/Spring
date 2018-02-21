/**
 * 
 */
package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.beans.Client;
import com.cg.dao.ICustomerDAO;

/**
 * @author aruravic
 *
 */

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerDAO customerDao;

	public ICustomerDAO getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(ICustomerDAO customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public Client getComplaintDetails(int complaintId) {

		return customerDao.getComplaintDetails(complaintId);
	}

	@Override
	public List<Client> getAllComplaintDetails() {
		return customerDao.getAllComplaintDetails();
	}

	@Override
	public Client addComplaintDetails(Client client) {
		client.setStatus("Open");
		if (client.getCategory().equals("Internet Banking")) {
			client.setPriority("High");
		} else if (client.getCategory().equals("General Banking")) {
			client.setPriority("Medium");
		} else {
			client.setPriority("Low");
		}

		return customerDao.addComplaintDetails(client);
	}

}
