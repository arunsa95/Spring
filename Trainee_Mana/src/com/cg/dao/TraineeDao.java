package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cg.beans.Login;
import com.cg.beans.Trainee;
import com.cg.exception.TraineeException;



/**
 * @author aruravic
 *
 */
@Repository
@EnableTransactionManagement
@Transactional
public class TraineeDao implements ITraineeDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Trainee addTrainee(Trainee trainee) {
		entityManager.persist(trainee);
		entityManager.flush();
		return trainee;
	}

	@Override
	public Trainee getTraineeDetails(int traineeId) {
		Trainee trainee = entityManager.find(Trainee.class, traineeId);
		return trainee;
	}

	@Override
	public List<Trainee> getAllTraineeDetails() {
		String sql = "SELECT tr FROM Trainee tr";
		TypedQuery<Trainee> query = entityManager.createQuery(sql,
				Trainee.class);
		List<Trainee> traineeList = query.getResultList();
		
		return traineeList;
	}

	@Override
	public boolean checkLogin(Login login) throws TraineeException {
try{
		String sql = "SELECT login FROM Login login where  login.username LIKE :pusername and login.password LIKE :ppassword";
		TypedQuery<Login> query = entityManager.createQuery(sql, Login.class);
		query.setParameter("pusername", login.getUsername());
		query.setParameter("ppassword", login.getPassword());

		if (query.getSingleResult() != null)

			return true;
		else
			return false;
	}catch(NoResultException e)
{
		throw new TraineeException("Wrong login credentials");
}catch(Exception e)
{
	throw new TraineeException("Something went wrong");
}
	}

	@Override
	public Trainee deleteTraineeDetails(int traineeId) {
		Trainee ntrainee = entityManager.find(Trainee.class,
				traineeId);
		entityManager.remove(ntrainee);
		return ntrainee;

	}

	

	@Override
	public Trainee modifyTraineeDetails(Trainee trainee) {
		entityManager.merge(trainee);
		entityManager.flush();
		return trainee;
	}

	/*
	 * @Override public List<Location> getLocationList() { String sql =
	 * "SELECT l FROM Location l"; TypedQuery<Location> query =
	 * entityManager.createQuery(sql, Location.class); List<Location>
	 * LocationList = query.getResultList();
	 * 
	 * return LocationList; }
	 */

}