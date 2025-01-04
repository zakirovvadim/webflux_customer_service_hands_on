package ru.vadim.customer_service.exceptions;

import reactor.core.publisher.Mono;

public class ApplicationExceptions {
    public static <T>Mono<T> customerNotFound(Integer customerId) {
        return Mono.error(new CustomerNotFoundException(customerId));
    }
    public static <T>Mono<T> insufficientBalance(Integer customerId) {
        return Mono.error(new InsufficientBalanceException(customerId));
    }
    public static <T>Mono<T> insufficientShare(Integer customerId) {
        return Mono.error(new InsufficientShareException(customerId));
    }
}
