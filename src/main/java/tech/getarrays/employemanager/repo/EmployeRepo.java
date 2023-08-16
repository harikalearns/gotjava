package tech.getarrays.employemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.getarrays.employemanager.model.Employe; 

import java.util.Optional;

public interface EmployeRepo extends JpaRepository<Employe, Long>{

	void deleteEmployeById(Long id);

	Optional<Employe> findEmployeById(Long id);
}
