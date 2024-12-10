package org.example;

import org.example.model.Trade;
import org.example.service.TradeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/trades")
public class TradeController {

    private TradeService tradeService;

    public TradeController() {
        tradeService = new TradeService();
    }

    @GetMapping
    public List<Trade> getAllTrades() {
        return tradeService.getAllTrades();
    }

    @PostMapping
    public boolean addTrade(@RequestBody Trade trade) {
        return tradeService.addTrade(trade);
    }
}
