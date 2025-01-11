package tn.iit.micro.service.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.iit.micro.service.student.request.CreateStudentRequest;
import tn.iit.micro.service.student.response.StudentResponse;

@Service
public interface IStudentService {

	StudentResponse createStudent(CreateStudentRequest createStudentRequest);

	StudentResponse getById(long id);

	List<StudentResponse> getAllStudents();
}
