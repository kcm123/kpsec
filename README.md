# 구축환경 및 프로젝트 구조

- Spring Boot

#### 공통 (com.example.kpsec.common)

- web : 테스트 컨트롤러
  - CommonController.java : 연결 확인을 위한 테스트 컨트롤러
  - ExceptionController.java : Exception handler
- util : 테스트 Utility 
- service : Swagger로 서비스 호출시 공통 서비스
- model : 메세지 VO

#### Swagger (com.example.kpsec.config)

- Configuration : SwaggerConfig.java (타이틀, 그룹, 탐색할 클래스 필터링)

- URL : http://localhost:8080/swagger-ui.html

- models : CommonResult.java (공통 return 메세지)

  {codestring : 응답 코드번호, messagestring : 응답메세지}

#### API 기능 구축 (com.example.kpsec.apiService)

- ApiController.java : Swagger 관련 Controller Mapping
- ApiService.java : 기능 구현
- ApiDAO.java : Mapper Interface



# 기능구현 

#### UNIT TEST (com.example/kpsec/KpsecApplicationTests.java)

1. 연도별 합계 금액이 가장 많은 고객 : getMaxSumCustomer()
2. 거래가 없는 고객(2018 or 2019) : getNoTransaction()
3. 거래 합계금액이 큰 순서로 출력 : getOrderByMax()
4. 지점명을 입력하면 해당지점의 거래금액 합계를 출력 : getSumAmt()

#### Swagger

1. 연도별 합계 금액이 가장 많은 고객

   Request URL : http://localhost:8080/getMaxSumCustomer

   Request Method : POST

2. 거래가 없는 고객(2018 or 2019)

   Request URL : http://localhost:8080/getNoTransaction

   Request Method : POST

3. 거래 합계금액이 큰 순서로 출력

   Request URL : http://localhost:8080/getOrderByMax

   Request Method : POST

4. 지점명을 입력하면 해당지점의 거래금액 합계를 출력

   Request URL : http://localhost:8080/getSumAmt

   Request Method : POST

   ApiParam : 관리점명 (* 필수)



# DB 관련 정보

- 설정 위치 : application.properties
  - spring.h2.console.path : localhost:8080**/h2-console**
  - spring.datasource.username : sa
  - mapper 위치 : /resources/mapper/*.xml
- 테이블 생성(create) 및 데이터 추가(Insert) : **schema.sql**
- db 종류 : h2
- 테스트 컴포넌트 : /common/util/H2Runner.java -> connection 정보(url, user ), 테스트 테이블 추가

## DB 테이블

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
