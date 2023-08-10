package tech.getarrays.employemanager;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tech.getarrays.employemanager.model.Employe;
import tech.getarrays.employemanager.service.EmployeService;
@RestController
@CrossOrigin(origins = {"http://localhost:8000", "http://localhost:4200"})
@RequestMapping("/employe")
public class EmployeResource {
	private final EmployeService employeService;


	public EmployeResource(EmployeService employeService) {
		this.employeService = employeService;

	}

	@GetMapping("/allemp")
	public ResponseEntity<List<Employe>> getAllEmployes () {
		List<Employe> employes =  employeService.findAllEmploye();
		return new ResponseEntity<>(employes, HttpStatus.OK);

	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Employe>getEmployeById (@PathVariable ("id") Long id) {
		Employe employe =  employeService.findEmployeById(id);
		return new ResponseEntity<>(employe, HttpStatus.OK);

	}

	@PostMapping("/add")
	public ResponseEntity<Employe> addEmploye(@RequestBody Employe employe){
		Employe newEmploye = employeService.addEmploye(employe);
		return new ResponseEntity<>(newEmploye, HttpStatus.CREATED);

	}

	@PutMapping("/update")
	public ResponseEntity<Employe> updateEmploye(@RequestBody Employe employe){
		Employe updateEmploye = employeService.updateEmploye(employe);
		return new ResponseEntity<>(updateEmploye, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmploye(@PathVariable ("id") Long id) {
		employeService.deleteEmploye(id);
		return new ResponseEntity<>( HttpStatus.OK);
	}
}
