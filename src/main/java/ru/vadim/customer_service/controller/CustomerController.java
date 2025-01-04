package ru.vadim.customer_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import ru.vadim.customer_service.dto.CustomerInformation;
import ru.vadim.customer_service.dto.StockTradeRequest;
import ru.vadim.customer_service.dto.StockTradeResponse;
import ru.vadim.customer_service.services.CustomerService;
import ru.vadim.customer_service.services.TradeService;

@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final TradeService tradeService;

    @GetMapping("/{customerId}")
    public Mono<CustomerInformation> getCustomerInformation(@PathVariable Integer customerId) {
        return this.customerService.getCustomerInformation(customerId);
    }

    @PostMapping("/{customerId}/trade")
    public Mono<StockTradeResponse> trade(@PathVariable Integer customerId, @RequestBody Mono<StockTradeRequest> mono) {
        return mono.flatMap(req -> this.tradeService.trade(customerId, req));
    }

}
