package org.example.dao;

import org.example.DatabaseConnection;
import org.example.model.Trade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TradeDao {

    // Pass Connection as a parameter to avoid closing it prematurely
    public List<Trade> getAllTrades(Connection connection) {
        List<Trade> trades = new ArrayList<>();
        String query = "SELECT * FROM trade";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Trade trade = new Trade();
                trade.setTradeId(resultSet.getInt("trade_id"));
                trade.setTraderId(resultSet.getInt("trader_id"));
                trade.setAmount(resultSet.getFloat("amount"));
                trade.setTradeDate(resultSet.getDate("trade_date"));
                trades.add(trade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trades;
    }

    public Double getRisk(Trade trade, Connection connection) {
        String query = "SELECT sum(amount) FROM trade WHERE trader_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, trade.getTraderId());  // Use trade.getTraderId() instead of trade.getTradeId()
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);  // Return the calculated sum
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    public boolean addTrade(Trade trade, Connection connection) {
        String query = "INSERT INTO trade (trader_id, amount, trade_date) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, trade.getTraderId());
            preparedStatement.setFloat(2, trade.getAmount());
            preparedStatement.setDate(3, trade.getTradeDate());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeTrade(int tradeId, Connection connection) {
        String query = "DELETE FROM trade WHERE trade_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, tradeId); // Set the trade_id to delete
            int rowsAffected = preparedStatement.executeUpdate(); // Execute the update
            return rowsAffected > 0; // Return true if a row was deleted
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
