# DB 테이블구조

  - **BANK_INFO** : 관리점정보

    | 구분       | 컬럼    | TYPE    | NULLABLE | PK   |
    | ---------- | ------- | ------- | -------- | ---- |
    | 관리점코드 | BANK_CD | VARCHAR | N        | PK   |
    | 관리점명   | BANK_NM | VARCHAR | N        |      |

  - **ACCT_INFO** : 계좌정보

    | 구분       | 컬럼    | TYPE    | NULLABLE | PK   |
    | ---------- | ------- | ------- | -------- | ---- |
    | 계좌번호   | ACCT_NO | INTEGER | N        | PK   |
    | 계좌명     | ACCT_NM | VARCHAR | N        |      |
    | 관리점코드 | BANK_CD | VARCHAR | Y        |      |

  - **TRANS_HIS** : 거래내역

    | 구분     | 컬럼      | TYPE    | NULLABLE | PK   |
    | -------- | --------- | ------- | -------- | ---- |
    | 거래일자 | TRANS_DT  | VARCHAR | N        | PK   |
    | 계좌번호 | ACCT_NO   | INTEGER | N        | PK   |
    | 거래번호 | TRANS_NO  | INTEGER | N        | PK   |
    | 금액     | AMOUNT    | INTEGER |          |      |
    | 수수료   | VAT       | INTEGER |          |      |
    | 취소여부 | CANCEL_YN | VARCHAR |          |      |
