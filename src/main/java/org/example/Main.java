package org.example;

import org.example.model.Trade;
import org.example.service.TradeService;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args){
        // Initialize service
        TradeService ts = new TradeService();


        // New trade data to be added
        Trade newTrade = new Trade();
        newTrade.setTraderId(101);  // assuming traderId = 101
        newTrade.setAmount(1000.50f);  // example trade amount
        newTrade.setTradeDate(Date.valueOf("2024-12-10"));

        // Use try-with-resources for automatic resource management
        // Ensure connection is open for all operations within the try block
        System.out.println("Connection successful!");

        Trade trade = new Trade();
        trade.setTraderId(1); // Ensure this is correctly set
        Double risk = ts.getRisk(trade);
        System.out.println("Risk for trade: " + risk);

        // Add the new trade

       /* boolean tradeAdded = ts.addTrade(newTrade);  // Pass the connection here
        if (tradeAdded) {
            System.out.println("Trade added successfully!");
        } else {
            System.out.println("Failed to add trade.");
        }

        */

        /*
        Trade removeTrade = new Trade();
        removeTrade.setTradeId(1);
        boolean isRemoved = ts.removeTrade(removeTrade);
        if (isRemoved) {
            System.out.println("Trade removed successfully!");
        } else {
            System.out.println("Failed to remove trade.");
        }

         */

        // Get and display all trades
        List<Trade> allTrades = ts.getAllTrades();
        System.out.println("All trades:");
        for (Trade t : allTrades) {
            System.out.println(t);  // Printing the trade object itself
        }

    }
}

        /* try {
            // Establish connection to the database
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful!");
            // Call the stored procedure using a PreparedStatement
            String procedureCall = "{ CALL insertTrade(?, ?, ?) }";
            stmt = conn.prepareStatement(procedureCall);

            // Set parameters for the stored procedure
            stmt.setInt(1, 1); // trader_id
            stmt.setFloat(2, 200f); // amount
            stmt.setDate(3, Date.valueOf("2024-12-10")); // trade_date

            // Execute the stored procedure
            stmt.executeUpdate();

            System.out.println("Trade inserted successfully!");

            if (conn != null) {
                int traderId = 1; // Example trader ID
                double exposure = RiskCalculator.calculateExposure(traderId, conn);
                System.out.println("Total exposure for trader " + traderId + ": $" + exposure);
            }
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    } */

