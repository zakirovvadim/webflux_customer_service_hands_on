package ru.vadim.customer_service.dto;

import ru.vadim.customer_service.domain.Ticker;
import ru.vadim.customer_service.domain.TradeAction;

public record StockTradeResponse(Integer customerId,
                                 Ticker ticker,
                                 Integer price,
                                 Integer quantity,
                                 TradeAction action,
                                 Integer totalPrice,
                                 Integer balance) {
}
