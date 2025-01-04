package ru.vadim.customer_service.mapper;

import ru.vadim.customer_service.domain.Ticker;
import ru.vadim.customer_service.dto.CustomerInformation;
import ru.vadim.customer_service.dto.Holding;
import ru.vadim.customer_service.dto.StockTradeRequest;
import ru.vadim.customer_service.dto.StockTradeResponse;
import ru.vadim.customer_service.entity.Customer;
import ru.vadim.customer_service.entity.PortfolioItem;

import java.util.List;

public class EntityDtoMapper {

    public static CustomerInformation toCustomerInformation(Customer customer, List<PortfolioItem> item){
        var holdings = item.stream()
                .map(i -> new Holding(i.getTicker(), i.getQuantity()))
                .toList();
        return new CustomerInformation(customer.getId(), customer.getName(), customer.getBalance(), holdings);
    }

    public static PortfolioItem toPortfolioItem(Integer customerId, Ticker ticker) {
        var portfolioItem = new PortfolioItem();
        portfolioItem.setCustomerId(customerId);
        portfolioItem.setTicker(ticker);
        portfolioItem.setQuantity(0);
        return portfolioItem;
    }

    public static StockTradeResponse toStockTradeResponse(StockTradeRequest request, Integer customerId, Integer balance) {
        return new StockTradeResponse(
                customerId,
                request.ticker(),
                request.price(),
                request.quantity(),
                request.action(),
                request.totalPrice(),
                balance
        );
    }
}
