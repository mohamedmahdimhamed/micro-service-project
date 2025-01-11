package tn.iit.micro.service.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.iit.micro.service.student.request.CreateStudentRequest;
import tn.iit.micro.service.student.response.StudentResponse;
import tn.iit.micro.service.student.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/create")
	public StudentResponse createStudent(@RequestBody CreateStudentRequest createStudentRequest) {
		return studentService.createStudent(createStudentRequest);
	}

	@GetMapping("/getById/{id}")
	public StudentResponse getById(@PathVariable long id) {
		return studentService.getById(id);
	}

	@GetMapping("/getAllStudent")
	public List<StudentResponse> getAll() {
		return studentService.getAllStudents();
	}
}
