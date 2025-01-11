package tn.iit.micro.service.address.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.iit.micro.service.address.request.CreateAddressRequest;
import tn.iit.micro.service.address.response.AddressResponse;

@Service
public interface IAdressService {

	AddressResponse createAddress(CreateAddressRequest createAddressRequest);

	AddressResponse getById(long id);

	List<AddressResponse> getAllAddresses();
}
