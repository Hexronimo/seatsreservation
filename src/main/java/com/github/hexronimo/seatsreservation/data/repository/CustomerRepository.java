package com.github.hexronimo.seatsreservation.data.repository;

import com.github.hexronimo.seatsreservation.data.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
