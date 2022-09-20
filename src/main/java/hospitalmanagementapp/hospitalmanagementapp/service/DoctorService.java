package hospitalmanagementapp.hospitalmanagementapp.service;

import java.util.List;
import hospitalmanagementapp.hospitalmanagementapp.entity.Doctor;


public interface DoctorService {
	public List<Doctor> getDoctor();
	  public String addNewDoctor(Doctor doctor);
	  public Doctor updateDoctor(Doctor doctor , int id);
	  public void deleteDoctor(int id);
}
