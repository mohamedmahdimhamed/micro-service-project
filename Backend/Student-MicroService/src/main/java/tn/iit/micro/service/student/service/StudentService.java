package tn.iit.micro.service.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.iit.micro.service.student.entity.Student;
import tn.iit.micro.service.student.proxy.AddressController;
import tn.iit.micro.service.student.repository.StudentRepository;
import tn.iit.micro.service.student.request.CreateAddressRequest;
import tn.iit.micro.service.student.request.CreateStudentRequest;
import tn.iit.micro.service.student.response.AddressResponse;
import tn.iit.micro.service.student.response.StudentResponse;

@Service
public class StudentService implements IStudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	AddressController client;

	@Override
	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
		CreateAddressRequest addressRequest = new CreateAddressRequest(createStudentRequest.getCity(),
				createStudentRequest.getStreet());
		AddressResponse address = client.createAddress(addressRequest);

		Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());
		student.setAddressId(address.getId());

		student = studentRepository.save(student);

		return new StudentResponse(student, address);
	}

	@Override
	public StudentResponse getById(long id) {
		Student student = studentRepository.findById(id).get();
		AddressResponse address = client.getById(student.getAddressId());
		return new StudentResponse(student, address);
	}

	@Override
	public List<StudentResponse> getAllStudents() {
		List<Student> studentList = studentRepository.findAll();
		List<StudentResponse> studentResponseList = new ArrayList<>();

		for (Student student : studentList) {
			if (student.getAddressId() != null) {
				AddressResponse addressResponse = client.getById(student.getAddressId());
				studentResponseList.add(new StudentResponse(student, addressResponse));
			} else {
				studentResponseList.add(new StudentResponse(student));
			}
		}

		return studentResponseList;
	}
}
