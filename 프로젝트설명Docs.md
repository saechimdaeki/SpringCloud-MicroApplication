# 전체 애플리케이션 구성요소



| 구성요소             | 설명                                          |
| :------------------- | --------------------------------------------- |
| `Git Repository`     | 마이크로서비스 소스 관리 및 프로파일 관리     |
| `Config Server`      | Git저장소에 등록된 프로파일 정보 및 설정 정보 |
| `Eureka Server`      | 마이크로서비스 등록 및 검색                   |
| `API Gateway Server` | 마이크로서비스 부하 분산 및 서비스 라우팅     |
| `Microservices`      | 회원 MS, 주문 MS, 상품(카테고리)MS            |
| `Queuing System`     | 마이크로서비스간 메시지 발행 및 구독          |

# 애플리케이션 APIs

| 마이크로서비스    | RESTful API                                                | HTTP Method |
| ----------------- | ---------------------------------------------------------- | ----------- |
| `Catalog Service` | /catalog-service/catalogs: 상품목록제공                    | GET         |
| `User Service`    | /user-service/users: 사용자 정보 등록                      | POST        |
|                   | /user-service/users: 전체 사용자 조회                      | GET         |
|                   | /user-service/users/{user_id}: 사용자 정보, 주문 내역 조회 | GET         |
| `Order Service`   | /order-service/users/{user_id}/orders: 주문 등록           | POST        |
|                   | /order-service/users/{user_id}/orders: 주문 확인           | GET         |



------



## Users Microservice

![image](https://user-images.githubusercontent.com/40031858/117565780-15d64100-b0ee-11eb-9d94-8fbd6f7eadbf.png)

- APIs

  | 기능                          | URI(API GATEWAY 사용시)          | URI(API Gateway 미사용시) | HTTP METHOD |
  | ----------------------------- | -------------------------------- | ------------------------- | ----------- |
  | `사용자 정보 등록`            | /user-service/users              | /users                    | POST        |
  | `전체 사용자 조회`            | /user-service/users              | /users                    | GET         |
  | `사용자 정보, 주문 내역 조회` | /user-service/users/{user_id}    | /users/{user_id}          | GET         |
  | `작동 상태 확인`              | /user-service/users/health_check | /users/health_chefck      | GET         |
  | `환영 메시지`                 | /user-service/users/welcome      | /users/welcome            | GET         |

  

  

  