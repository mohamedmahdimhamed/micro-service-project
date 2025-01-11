package tn.micro.service.cloud.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import tn.micro.service.cloud.entity.Student;
import tn.micro.service.cloud.proxy.AddressController;
import tn.micro.service.cloud.repository.StudentRepository;
import tn.micro.service.cloud.request.CreateAdressRequest;
import tn.micro.service.cloud.request.CreateStudentRequest;
import tn.micro.service.cloud.response.AdressResponse;
import tn.micro.service.cloud.response.StudentResponse;

@Service
public class StudentService implements IStudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	AddressController client;

	//@Autowired
	//WebClient webClient;

	@Override
	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
		CreateAdressRequest adressRequest = new CreateAdressRequest(createStudentRequest.getCity(),createStudentRequest.getStreet());
		AdressResponse adress = client.createAddress(adressRequest);

		Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());
		student.setAddressId(adress.getId());

		student = studentRepository.save(student);

		return new StudentResponse(student, adress);
	}

//	private AdressResponse createAdressWithWebClient(CreateAdressRequest request) {
//		
//		return webClient.post().uri("/create").contentType(MediaType.APPLICATION_JSON)
//				.bodyValue(request).retrieve().bodyToMono(AdressResponse.class).block();
//	}

	@Override
	public StudentResponse getById(long id) {
		Student student = studentRepository.findById(id).get();
		AdressResponse adress = client.getById(student.getAddressId());
		return new StudentResponse(student, adress);
	}

	@Override
	public List<StudentResponse> getAllStudents() {
		List<Student> studentList = studentRepository.findAll();
        List<StudentResponse> studentResponseList = new ArrayList<>();
        
        for (Student student : studentList) {
            if (student.getAddressId() != null) {
                // Si l'étudiant a une adresse, utiliser le constructeur avec adresse
                AdressResponse addressResponse = client.getById(student.getAddressId());
                studentResponseList.add(new StudentResponse(student, addressResponse));
            } else {
                // Si l'étudiant n'a pas d'adresse, utiliser le constructeur simple
                studentResponseList.add(new StudentResponse(student));
            }
        }
        
        return studentResponseList;	}

//	public Mono<AdressResponse> getAddress(Long addressId) {
//		return webClient.get() // Déclare une requête GET
//				.uri("/getById/" + addressId) // Ajoute l'ID à l'URI
//				.retrieve() // Exécute l'appel
//				.bodyToMono(AdressResponse.class); // Convertit la réponse en un objet de type Response
//	}
}
