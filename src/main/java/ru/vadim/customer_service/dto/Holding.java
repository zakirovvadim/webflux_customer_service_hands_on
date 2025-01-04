package ru.vadim.customer_service.dto;

import ru.vadim.customer_service.domain.Ticker;

public record Holding(Ticker ticker,
                      Integer quantity) {
}
