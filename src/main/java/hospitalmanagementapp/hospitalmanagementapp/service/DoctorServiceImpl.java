package hospitalmanagementapp.hospitalmanagementapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import hospitalmanagementapp.hospitalmanagementapp.data.DoctorData;
import hospitalmanagementapp.hospitalmanagementapp.entity.Doctor;
import hospitalmanagementapp.hospitalmanagementapp.exception.ResourceNotFound;


@Service
public class DoctorServiceImpl implements DoctorService{
	@Autowired
    private DoctorData data;
	@Override
	public List<Doctor> getDoctor() {
		List<Doctor> doctors = data.findAll(Sort.by(Sort.Direction.DESC, "salary").and(Sort.by(Sort.Direction.ASC , "name")));
		
		return doctors;
	}
	@Override
	public String addNewDoctor(Doctor doctor) {
		Doctor existingDoctor = data.findById(doctor.getId()).orElse(null);
		if(existingDoctor ==null) {
		 data.save(doctor);
		 return "New Doctor added successfully";
		}
		else {
			return "Doctor Already Exists in Database";
		}
	}
	@Override
	public Doctor updateDoctor(Doctor doctor, int id) {
		Doctor existingDoctor = data.findById(id).orElseThrow(
				() -> new ResourceNotFound("Doctor", "Id", id));
		existingDoctor.setName(doctor.getName());
		existingDoctor.setSalary(doctor.getSalary());
		existingDoctor.setSpecialist(doctor.getSpecialist());
		data.save(existingDoctor);
		return existingDoctor;
	}
	@Override
	public void deleteDoctor(int id) {
		data.findById(id).orElseThrow(() -> new ResourceNotFound("Doctor", "Id", id));
		data.deleteById(id);
		
	}
}
