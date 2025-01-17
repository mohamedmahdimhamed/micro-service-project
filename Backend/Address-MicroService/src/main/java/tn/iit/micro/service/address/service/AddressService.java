package tn.iit.micro.service.address.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.iit.micro.service.address.entity.Address;
import tn.iit.micro.service.address.repository.AddressRepository;
import tn.iit.micro.service.address.request.CreateAddressRequest;
import tn.iit.micro.service.address.response.AddressResponse;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;

	public AddressResponse createAddress(CreateAddressRequest createAddressRequest) {
		
		Address address = new Address();
		address.setStreet(createAddressRequest.getStreet());
		address.setCity(createAddressRequest.getCity());

		address = addressRepository.save(address);

		return new AddressResponse(address);
	}

	public AddressResponse getById(long id) {
		Address address = addressRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Address with id: " + id +"not found "));
		return new AddressResponse(address);
	}

	public List<AddressResponse> getAllAddresses() {
		List<Address> addresses = addressRepository.findAll();
		return addresses.stream().map(AddressResponse::new).collect(Collectors.toList());
	}
}
