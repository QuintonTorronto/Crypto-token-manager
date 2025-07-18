package com.crypto.tokenmanager.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;


public class TokenDAO {
    private static final Logger logger = Logger.getLogger(TokenDAO.class.getName());

    private static final String DB_URL = EnvLoader.get("DB_URL");
    private static final String DB_USER = EnvLoader.get("DB_USER");
    private static final String DB_PASS = EnvLoader.get("DB_PASS");


    public Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    public void addToken(Token token) {
        String sql = "INSERT INTO tokens (name, symbol, price_usd, market_cap_usd, total_supply) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, token.getName());
            stmt.setString(2, token.getSymbol());
            stmt.setDouble(3, token.getPriceUsd());
            stmt.setDouble(4, token.getMarketCapUsd());
            stmt.setDouble(5, token.getTotalSupply());
            stmt.executeUpdate();
            logger.info("Token added.");
        } catch (SQLException e) {
            logger.log(Level.SEVERE," Error adding token: ",e);
        }
    }

    public List<Token> getAllTokens() {
        List<Token> tokens = new ArrayList<>();
        String sql = "SELECT * FROM tokens ORDER BY id";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                tokens.add(new Token(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("symbol"),
                        rs.getDouble("price_usd"),
                        rs.getDouble("market_cap_usd"),
                        rs.getDouble("total_supply")
                ));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE,"Error fetching tokens: ", e);
        }
        return tokens;
    }

    public void updateToken(Token token) {
        String sql = "UPDATE tokens SET name = ?, symbol = ?, price_usd = ?, market_cap_usd = ?, total_supply = ? WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, token.getName());
            stmt.setString(2, token.getSymbol());
            stmt.setDouble(3, token.getPriceUsd());
            stmt.setDouble(4, token.getMarketCapUsd());
            stmt.setDouble(5, token.getTotalSupply());
            stmt.setInt(6, token.getId());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) logger.info("Token updated.");
            else logger.info(" Token not found.");
        } catch (SQLException e) {
            logger.log(Level.SEVERE,"Error updating token: " , e);
        }
    }

    public void deleteToken(int id) {
        String sql = "DELETE FROM tokens WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) logger.info("Token deleted.");
            else logger.info("Token ID not found.");
        } catch (SQLException e) {
            logger.log(Level.SEVERE,"Error deleting token: " , e);
        }
    }
}
    