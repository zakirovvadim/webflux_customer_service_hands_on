package ru.vadim.customer_service.services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.vadim.customer_service.dto.CustomerInformation;
import ru.vadim.customer_service.entity.Customer;
import ru.vadim.customer_service.exceptions.ApplicationExceptions;
import ru.vadim.customer_service.mapper.EntityDtoMapper;
import ru.vadim.customer_service.repository.CustomerRepository;
import ru.vadim.customer_service.repository.PortfolioItemRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final PortfolioItemRepository portfolioItemRepository;

    public CustomerService(CustomerRepository customerRepository, PortfolioItemRepository portfolioItemRepository) {
        this.customerRepository = customerRepository;
        this.portfolioItemRepository = portfolioItemRepository;
    }

    public Mono<CustomerInformation> getCustomerInformation(Integer customerId) {
        return this.customerRepository.findById(customerId)
                .switchIfEmpty(ApplicationExceptions.customerNotFound(customerId))
                .flatMap(this::buildCustomerInformation);
    }

    private Mono<CustomerInformation> buildCustomerInformation(Customer customer) {
        return this.portfolioItemRepository.findAllByCustomerId(customer.getId())
                .collectList()
                .map(list -> EntityDtoMapper.toCustomerInformation(customer, list));
    }
}
