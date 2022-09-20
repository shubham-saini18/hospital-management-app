package hospitalmanagementapp.hospitalmanagementapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

import hospitalmanagementapp.hospitalmanagementapp.entity.Doctor;



public interface DoctorData extends JpaRepository<Doctor, Integer>{

}
