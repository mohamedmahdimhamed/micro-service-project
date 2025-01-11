package tn.micro.service.cloud.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tn.micro.service.cloud.request.CreateAdressRequest;
import tn.micro.service.cloud.response.AdressResponse;


@FeignClient(value = "api-gateway")
public interface AddressController {

	@PostMapping("/address-service/api/address/create")
	AdressResponse createAddress(@RequestBody CreateAdressRequest createAddressRequest);

	@GetMapping("/address-service/api/address/getById/{id}")
	AdressResponse getById(@PathVariable long id) ;

}
