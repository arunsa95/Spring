package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.beans.Login;
import com.cg.beans.Trainee;
import com.cg.dao.ITraineeDao;
import com.cg.exception.TraineeException;



/**
 * @author aruravic
 *
 */
@Service
public class TraineeService implements ITraineeService {

	@Autowired
	ITraineeDao traineeDao;

	public ITraineeDao getTraineeDao() {
		return traineeDao;
	}

	public void setTraineeDao(ITraineeDao traineeDao) {
		this.traineeDao = traineeDao;
	}

	@Override
	public Trainee addTrainee(Trainee trainee) {

		return traineeDao.addTrainee(trainee);
	}

	@Override
	public Trainee getTraineeDetails(int traineeId) {

		return traineeDao.getTraineeDetails(traineeId);
	}

	@Override
	public List<Trainee> getAllTraineeDetails() {

		return traineeDao.getAllTraineeDetails();
	}

	@Override
	public boolean checkLogin(Login login) throws TraineeException {
		
		return traineeDao.checkLogin(login);
	}



	
	@Override
	public Trainee deleteTraineeDetails(int traineeId) {
		
		return traineeDao.deleteTraineeDetails(traineeId);
	}

	@Override
	public Trainee modifyTraineeDetails(Trainee trainee) {
		
		return traineeDao.modifyTraineeDetails(trainee);
	}

	/*
	 * @Override public List<Location> getLocationList() {
	 * 
	 * return traineeDao.getLocationList(); }
	 */
	

}
