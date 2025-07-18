package com.crypto.tokenmanager.app;

import com.crypto.tokenmanager.model.Token;
import com.crypto.tokenmanager.dao.TokenDAO;
import com.crypto.tokenmanager.util.ConsoleFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;
import java.util.logging.Level;

public class CryptoTokenApp {

    private static final Logger logger = Logger.getLogger(CryptoTokenApp.class.getName());

    static {
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new ConsoleFormatter());
        handler.setLevel(Level.ALL);

        logger.setUseParentHandlers(false); // prevent default formatter
        logger.addHandler(handler);
        logger.setLevel(Level.ALL);
    }

    public static void main(String[] args) {

        TokenDAO dao = new TokenDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            logger.info("\n==== CRYPTO TOKEN MANAGER ====");
            logger.info("1. Add new token");
            logger.info("2. View all tokens");
            logger.info("3. Update token");
            logger.info("4. Delete token");
            logger.info("5. Exit");
            logger.info("Enter choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> {
                    logger.info("Name: ");
                    String name = sc.nextLine();
                    logger.info("Symbol: ");
                    String symbol = sc.nextLine();
                    logger.info("Price (USD): ");
                    double price = Double.parseDouble(sc.nextLine());
                    logger.info("Market Cap (USD): ");
                    double cap = Double.parseDouble(sc.nextLine());
                    logger.info("Total Supply: ");
                    double supply = Double.parseDouble(sc.nextLine());
                    dao.addToken(new Token(name, symbol, price, cap, supply));
                }
                case 2 -> {
                    List<Token> tokens = dao.getAllTokens();
                    if (tokens.isEmpty())
                        logger.info(" No tokens found.");
                    else {
                        logger.info("Fetched token list:");
                        for (Token token : tokens) {
                            logger.info(token.toString());
                        }
                    }
                }

                case 3 -> {
                    logger.info("Enter ID to update: ");
                    int id = Integer.parseInt(sc.nextLine());
                    logger.info("New Name: ");
                    String name = sc.nextLine();
                    logger.info("New Symbol: ");
                    String symbol = sc.nextLine();
                    logger.info("New Price (USD): ");
                    double price = Double.parseDouble(sc.nextLine());
                    logger.info("New Market Cap (USD): ");
                    double cap = Double.parseDouble(sc.nextLine());
                    logger.info("New Total Supply: ");
                    double supply = Double.parseDouble(sc.nextLine());
                    dao.updateToken(new Token(id, name, symbol, price, cap, supply));
                }
                case 4 -> {
                    logger.info("Enter ID to delete: ");
                    int id = Integer.parseInt(sc.nextLine());
                    dao.deleteToken(id);
                }
                case 5 -> {
                    logger.info("Exiting...");
                    return;
                }
                default -> logger.info("Invalid choice.");
            }
        }
    }
}
