package tn.iit.micro.service.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.micro.service.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	
	
}
