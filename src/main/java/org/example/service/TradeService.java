package org.example.service;

import org.example.DatabaseConnection;
import org.example.dao.TradeDao;
import org.example.model.Trade;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TradeService {
    private TradeDao tradeDao;
    private Connection connection;

    public TradeService() {
        tradeDao = new TradeDao();
        try {
            connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Trade> getAllTrades(){
        return tradeDao.getAllTrades(connection);
    }

    public Double getRisk(Trade trade){
        return tradeDao.getRisk(trade, connection);
    }

    public boolean addTrade(Trade trade){
        return tradeDao.addTrade(trade, connection);
    }

    public boolean removeTrade(Trade trade){
        return tradeDao.removeTrade(trade.getTradeId(), connection);
    }
}
