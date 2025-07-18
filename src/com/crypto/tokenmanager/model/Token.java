package com.crypto.tokenmanager.model;

public class Token {
    private int id;
    private String name;
    private String symbol;
    private double priceUsd;
    private double marketCapUsd;
    private double totalSupply;

    public Token() {
    }

    public Token(String name, String symbol, double priceUsd, double marketCapUsd, double totalSupply) {
        this.name = name;
        this.symbol = symbol;
        this.priceUsd = priceUsd;
        this.marketCapUsd = marketCapUsd;
        this.totalSupply = totalSupply;
    }

    public Token(int id, String name, String symbol, double priceUsd, double marketCapUsd, double totalSupply) {
        this(name, symbol, priceUsd, marketCapUsd, totalSupply);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPriceUsd() {
        return priceUsd;
    }

    public double getMarketCapUsd() {
        return marketCapUsd;
    }

    public double getTotalSupply() {
        return totalSupply;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setPriceUsd(double priceUsd) {
        this.priceUsd = priceUsd;
    }

    public void setMarketCapUsd(double marketCapUsd) {
        this.marketCapUsd = marketCapUsd;
    }

    public void setTotalSupply(double totalSupply) {
        this.totalSupply = totalSupply;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | %s (%s) | Price: $%.6f | Market Cap: $%.2f | Supply: %.2f",
                id, name, symbol, priceUsd, marketCapUsd, totalSupply);
    }
}
