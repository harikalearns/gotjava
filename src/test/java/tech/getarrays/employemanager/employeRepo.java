package tech.getarrays.employemanager;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.getarrays.employemanager.model.Employe;

public interface employeRepo extends JpaRepository<Employe, Long >{

}
