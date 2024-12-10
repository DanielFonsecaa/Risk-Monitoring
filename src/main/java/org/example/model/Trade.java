package org.example.model;

import java.sql.Date;

public class Trade {
    private int tradeId;
    private int traderId;
    private float amount;
    private java.sql.Date tradeDate;

    public int getTradeId() {
        return tradeId;
    }

    public void setTradeId(int tradeId) {
        this.tradeId = tradeId;
    }

    public int getTraderId() {
        return traderId;
    }

    public void setTraderId(int traderId) {
        this.traderId = traderId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }
    @Override
    public String toString() {
        return "Trade{" +
                "tradeId=" + tradeId +
                ", traderId=" + traderId +
                ", amount=" + amount +
                ", tradeDate=" + tradeDate +
                '}';
    }
}


