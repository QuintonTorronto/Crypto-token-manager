CREATE TABLE IF NOT EXISTS tokens (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    symbol VARCHAR(10) UNIQUE NOT NULL,
    price_usd NUMERIC(20,10) NOT NULL,
    market_cap_usd NUMERIC(30,2),
    total_supply NUMERIC(30,2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
