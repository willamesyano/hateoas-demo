DROP TABLE IF EXISTS FINANCIAL_ASSET;
CREATE TABLE FINANCIAL_ASSET(
    ID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    NAME VARCHAR(255) NOT NULL,
    MARKET_VALUE_CODE INTEGER DEFAULT 0 NOT NULL,
    TYPE VARCHAR(255) NOT NULL,
    INITIAL_TOTAL_OFFERING_QUANTITY INTEGER NOT NULL,
    ISSUE_DATE TIMESTAMP NOT NULL,
    MATURITY_DATE TIMESTAMP NOT NULL,
    QUANTITY INTEGER NOT NULL
);
