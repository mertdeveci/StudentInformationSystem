package com.SNI.SIS.Repository;

import com.SNI.SIS.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Long> {
}
