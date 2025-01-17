package tn.iit.micro.service.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.micro.service.address.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
