CREATE TABLE ACCT_INFO (
    ACCT_NO INTEGER NOT NULL,
    ACCT_NM VARCHAR(100) NOT NULL,
    BANK_CD VARCHAR(10),
    PRIMARY KEY(ACCT_NO)
) AS SELECT * FROM CSVREAD('classpath:/db/ACCT_INFO.csv');

CREATE TABLE BANK_INFO (
                           BANK_CD VARCHAR(10) NOT NULL,
                           BANK_NM VARCHAR(100) NOT NULL,
                           PRIMARY KEY(BANK_CD)
) AS SELECT * FROM CSVREAD('classpath:/db/BANK_INFO.csv');

CREATE TABLE TRANS_HIS (
                           TRANS_DT VARCHAR(10) NOT NULL,
                           ACCT_NO INTEGER NOT NULL,
                           TRANS_NO INTEGER NOT NULL,
                           AMOUNT INTEGER,
                           VAT INTEGER,
                           CANCEL_YN VARCHAR(2)
) AS SELECT * FROM CSVREAD('classpath:/db/TRANS_HIS.csv');