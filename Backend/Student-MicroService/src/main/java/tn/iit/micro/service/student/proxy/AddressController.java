package tn.iit.micro.service.student.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tn.iit.micro.service.student.request.CreateAddressRequest;
import tn.iit.micro.service.student.response.AddressResponse;

@FeignClient(value = "api-gateway")
public interface AddressController {

	@PostMapping("/address-service/api/address/create")
	AddressResponse createAddress(@RequestBody CreateAddressRequest createAddressRequest);

	@GetMapping("/address-service/api/address/getById/{id}")
	AddressResponse getById(@PathVariable long id);

}
