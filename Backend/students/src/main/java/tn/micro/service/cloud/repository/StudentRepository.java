package tn.micro.service.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.micro.service.cloud.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	
	
}
