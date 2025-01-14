package ru.vadim.customer_service.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import ru.vadim.customer_service.entity.Customer;

@Repository
public interface CustomerRepository extends ReactiveCrudRepository<Customer, Integer> {
}
