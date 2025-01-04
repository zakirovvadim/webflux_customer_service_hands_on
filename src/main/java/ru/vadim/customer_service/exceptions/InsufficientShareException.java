package ru.vadim.customer_service.exceptions;

public class InsufficientShareException extends RuntimeException {

    public static final String MESSAGE = "Customer [id=%d] does not have enough shares to complete the transaction";

    public InsufficientShareException(Integer customerId) {
        super(MESSAGE.formatted(customerId));
    }
}
