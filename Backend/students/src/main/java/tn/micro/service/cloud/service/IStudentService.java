package tn.micro.service.cloud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.micro.service.cloud.request.CreateStudentRequest;
import tn.micro.service.cloud.response.StudentResponse;

@Service
public interface IStudentService {

	StudentResponse createStudent(CreateStudentRequest createStudentRequest);

	StudentResponse getById(long id);

	List<StudentResponse> getAllStudents();
}
