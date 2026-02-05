package TP2.StockApplication;

import TP2.StockApplication.service.StockService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class StockConsumer {
    private final StockService stockService;

    public StockConsumer(StockService stockService) {
        this.stockService = stockService;
    }

    @KafkaListener(topics = "stock-topic", groupId = "stock-group")
    public void listen(String message) {
        String[] parts = message.split(":");
        String nom = parts[0];
        int qte = Integer.parseInt(parts[1]);

        stockService.modifierStock(nom, -qte);
    }
}
