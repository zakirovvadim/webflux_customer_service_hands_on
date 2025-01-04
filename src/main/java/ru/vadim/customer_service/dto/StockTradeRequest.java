package ru.vadim.customer_service.dto;

import ru.vadim.customer_service.domain.Ticker;
import ru.vadim.customer_service.domain.TradeAction;

public record StockTradeRequest(Ticker ticker,
                                Integer price,
                                Integer quantity,
                                TradeAction action) {

    public Integer totalPrice() {
        return price * quantity;
    }
}
