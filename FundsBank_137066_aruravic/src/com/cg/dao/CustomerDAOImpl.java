/**
 * 
 */
package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.cg.beans.Client;

/**
 * @author aruravic
 *
 */
@Repository
@EnableTransactionManagement
@Transactional
public class CustomerDAOImpl implements ICustomerDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Client getComplaintDetails(int complaintId) {

		Client client = entityManager.find(Client.class, complaintId);
		return client;

	}

	@Override
	public List<Client> getAllComplaintDetails() {
		String sql = "SELECT c FROM Complaint c";
		TypedQuery<Client> query = entityManager.createQuery(sql, Client.class);
		List<Client> complaintList = query.getResultList();

		return complaintList;
	}

	@Override
	public Client addComplaintDetails(Client client) {
		entityManager.persist(client);
		entityManager.flush();
		return client;
	}

}
