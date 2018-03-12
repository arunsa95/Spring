package com.cg.service;

import java.util.List;

import com.cg.beans.Login;
import com.cg.beans.Trainee;
import com.cg.exception.TraineeException;

/**
 * @author aruravic
 *
 */
public interface ITraineeService {
	public Trainee addTrainee(Trainee trainee);

	public Trainee getTraineeDetails(int traineeId);

	public Trainee modifyTraineeDetails(Trainee trainee);

	public List<Trainee> getAllTraineeDetails();

	public boolean checkLogin(Login login) throws TraineeException;

	public Trainee deleteTraineeDetails(int traineeId);

	// public List<Location> getLocationList();

}
