package tech.getarrays.employemanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tech.getarrays.employemanager.exception.UserNotFoundException;
import tech.getarrays.employemanager.model.Employe;
import tech.getarrays.employemanager.repo.EmployeRepo;




@Service
@Transactional
public class EmployeService {
	private EmployeRepo employeRepo = null;

	@Autowired     
	public EmployeService(EmployeRepo employeRepo) {
		this.employeRepo = employeRepo;
	}


	public Employe addEmploye(Employe employe) {
		employe.setEmployeeCode(UUID.randomUUID().toString());
		return employeRepo.save(employe);
	}
	public List<Employe>findAllEmploye(){
		return employeRepo.findAll();	
	}
	public Employe updateEmploye(Employe employe) {
		return employeRepo.save(employe);
	}

	public Employe findEmployeById(Long id) {
		return employeRepo.findEmployeById(id)
				.orElseThrow(()-> new UserNotFoundException("User by id " + id + " was not found" ));
	}
	public void deleteEmploye(Long id) {
		employeRepo.deleteEmployeById(id);

	}

}




