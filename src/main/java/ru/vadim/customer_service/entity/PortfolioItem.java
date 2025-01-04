package ru.vadim.customer_service.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import ru.vadim.customer_service.domain.Ticker;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PortfolioItem {

    @Id
    private Integer id;
    private Integer customerId;
    private Ticker ticker;
    private Integer quantity;
}
