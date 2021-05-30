# SpringCloud-MicroApplication

Spring Cloud로 개발하는 마이크로서비스 애플리케이션 실습 저장소입니다

### Cloud Native Architecture

- 확장 가능한 아키텍처
    - 시스템의 수평적 확장에 유연
    - 확장된 서버로 시스템의 부하 분산, 가용성 보장
    - 시스템 또는, 서비스 애플리케이션 단위의 패키지 (컨테이너 기반 패키지)
    - 모니터링
- 탄력적 아키텍처
    - 서비스 생성-통합-배포, 비즈니스 환경 변화에 대응 시간. 단축
    - 분할 된 서비스 구조
    - 서비스의 추가와 삭제 자동으로 감지
    - 변경된 서비스 요청에 따라 사용자 요청 처리(동적 처리)
- 장애 격리(Fault isolation)
    - 특정 서비스에 오류가 발생해도 다른 서비스에 영향 주지 않음

---

### Cloud Native Application - CI/CD

- 지속적인 통합, CI(Continuous Integration)
    - 통합 서버, 소스 관리(SCM), 빌드 도구, 테스트 도구
    - Ex) Jenkins, Team CI, Travis CI
- 지속적 배포
    - Continuous Delivery
    - Continuous Deployment
    - Pipe line
- 카나리 배포와 블루그린 배포

![image](https://user-images.githubusercontent.com/40031858/116813533-1a02db80-ab8f-11eb-8e00-e231b0eac251.png)

### Cloud Native Application - DevOps

![image](https://user-images.githubusercontent.com/40031858/116813580-52a2b500-ab8f-11eb-8e37-9e871f7ee463.png)

### Cloud Native Application - Container 가상화

![image](https://user-images.githubusercontent.com/40031858/116813633-95648d00-ab8f-11eb-8f67-fae038d6cfd9.png)

---

### SOA와 MSA와의 차이점

- 서비스의 공유 지향점
    - SOA - 재사용을 통한 비용 절감
    - MSA - 서비스 간의 결합도를 낮추어 변화에 능동적으로 대응
- 기술방식
    - SOA- 공통의 서비스를 ESB에 모아 사업 측면에서 공통서비스 형식으로 서비스 제공
    - MSA- 각 독립된 서비스가 노출된 REST API 를 사용 

---

### Netflix Ribbon

- Spring Cloud에서의 MSA간 통신

1) RestTemplate

```java
RestTemplate restTemplate=new RestTemplate();
restTemplate.getForObject("http://localhost:8080/",User.class,200);
```

2) Feign Client

```java
@FeignClient("stores")
public interface StoreClient{
  @RequestMapping(method=RequestMethod.GET, value="/stores")
  List<Store> getStores();
}
```

- Ribbon: Client side Load Balancer
  - 서비스 이름으로 호출
  - Health Check

- Spring Cloud Ribbon은 Spring Boot 2.4에서 Maintenance상태..



----

### Token 기반 인증 시스템 ex) JWT

- JWT (JSON Web Token)
  - Https://jwt.io/
  - 인증 헤더 내에서 사용되는 토큰 포맷
  - 두개의 시스템끼리 안전한 방법으로 통신가능

- JWT(JSON WEB TOKEN) 장점
  - 클라이언트 독립적인 서비스 (stateless)
  - CDN
  - No Cookie- Session (No CSRF, 사이트간 요청위조)
  - 지속적인 토큰 저장

---

# Spring Cloud Config

- 분산 시스템에서 서버 클라이언트 구성에 필요한 설정 정보(application.yml)를 외부 시스템에서 관리
- 하나의 중앙화 된 저장소에서 구성요소 관리 가능
- 각 서비스를 다시 빌드하지 않고, 바로 적응 가능
- 애플리케이션 배포 파이프라인을 통해 DEV-UAT-PROD 환경에 맞는 구성정보사용

![image](https://user-images.githubusercontent.com/40031858/119257944-9030b600-bc02-11eb-9382-80e61cb89caa.png)

----

# Spring Cloud Bus

### AMQP(Advanced Message Queuing Protocol) , 메시지 지향 미들웨어를 위한 개방형 표준 응용 계층 프로토콜

- 메시지 지향, 큐잉, 라우팅 (P2P, Publisher-Subscriber), 신뢰성, 보안
- Erlang, RabbitMQ에서 사용

### Kafka프로젝트

- Apache Software Foundation 이 Scalar언어로 개발한 오픈소스 메시지 브로커 프로젝트
- 분산형 스트리밍 플랫폼
- 대용량의 데이터를 처리 가능한 메시징 시스템



### RabbitMQ vs Kafka

- RabbitMQ
  - 메시지 브로커
  - 초당 20+메시지를 소비자에게 전달
  - 메시지 전달 보장, 시스템 간 메시지 전달
  - 브로커, 소비자 중심
- Kafka
  - 초당 100k+ 이상의 이벤트 처리
  - Pub/Sub, Topic에 메시지 전달
  - Ack를 기다리지 않고 전달 가능
  - 생산자 중심

### Actuator bus-refresh Endpoint

- 분산시스템의 노드를 경량 메시지 브로커와 연결
- 상태 및 구성에 대한 변경 사항을 연결된 노드에게 전달 (Broadcast)



Export PATH=$PATH:/usr/local/sbin

rabbitmq== default port:15672 id: gest pwd:guest

start==rabbitmq-server





---



# Fegin Web Service Client

- FeignClient -> HTTP Client
  - REST Call 을 추상화한 Spring Cloud Netflix 라이브러리
- 사용 방법
  - 호출하려는 HTTP Endpoint에 대한 Interface를 생성
  - @FeginClient선언
- Load balanced 지원



----



# Apache Kafka

- Apache Software Foundation의 Scalar 언어로 된 오픈소스 메시지 브로커 프로젝트
  - Open Source Message Broker Project
- 링크드인(Linked-in)에서 개발, 2011년 오픈 소스화
  - 2014년 11월 링크드인에서 kafka를 개발하던 엔지니어들이 kafka개발에 집중하기위해 Confluent라는 회사 창립
- 실시간 데이터 피드를 관리하기 위해 통일된 높은 처리량, 낮은 지연 시간을 지닌 플랫폼 제공
- Apple, Netflix, Shopify, Yelp, Kakao, New York Times, Cisco, Ebay, PayPal, Hyperledger Fabric, Uber, Salesforce.com등이 사용



- Producer/Consumer 분리
- 메시지를 여러 Consumer에게 허용
- 높은 처리량을 위한 메시지 최적화
- Scale-out 가능
- Eco-system



### Kafka Broker

- 실행된 Kafka 애플리케이션 서버
- 3대 이상의 Broker Cluster 구성
- Zookeeper 연동
  - 역할: 메타데이터 (Broker ID, Controller ID 등) 저장
  - Controller 정보 저장
- n개 Broker 중 1대는 Controller 기능 수행
  - Controller 역할
    - 각 Broker에게 담당 파티션 할당 수행
    - Broker 정상 동작 모니터링 관리

---

### EcoSystem 1 - Kafka Client

- Kafka와 데이터를 주고받기 위해 사용하는 Java Library
- Producer, Consumer, Admin, Stream end Kafka관련 API 제공
- 다양한 3rd party library 존재: c/c++, Node.js, Python, .NET 등 



### Kafka 서버 기동

- Zookeeper 및 Kafka 서버 구동
  - $KAFKA_HOME/bin/zookeeper-server-start.sh
    - $KAFKA_HOME/config/zookeeper.properties
  - $KAFKA_HOME/bin/kafka-server-start.sh
    - $KAFKA_HOME/config/server.properties

- Topic 생성
  - $KAFKA_HOME/bin/kafka-topics.sh --create --topic QuickStart-events --bootstrap-server localhost:9092 \ --partitions 1
- Topic 목록 확인
  - $KAFKA_HOME/bin/kafka-topics.sh --bootstrap-server localhost:9092 --list
- Topic 정보 확인
  - $KAFKA_HOME/bin/kafka-topics.sh --decsribe --topic quickstart-events --bootstrap-server localhost:9092

---

### Kafka Producer / Consumer 테스트

- 메시지 생산
  - $KAFKA_HOME/bin/kafka-console-producer.sh --broker-list localhost:9092 --topic quickstart-events
- 메시지 소비
  - $KAFKA_HOME/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic quickstart-events \ --from-beginning

---

### Ecosystem 2 - Kafka Connect

- kafka Connect를 통해 Data를 Import/Export 가능
- 코드 없이 Configuration으로 데이터를 이동
- Standalone mode, Distrubution mode 지원
  - RESTful API 통해 지원
  - Stream 또는 Batch 형태로 데이터 전송 가능
  - 커스텀 Connector를 통한 다양한 plugin 제공 (File,S3, Hive, Mysql, etc ...)

---

### Kafka Connect 설치

- Kafka Connect 설치
- Kafka Connect 설정 (기본으로 사용)
  - $KAFKA_HOME/config/connect-distributed.properties
- Kafka Connect 실행
  - ./bin/connect-distributed ./etc/kafka/connect-distributed.properties
- Topic 목록 확인
  - ./bin/kafka-topics.sh --bootstrap-server localhost:9092 --list
- JDBC Connector 설치
- Etc/kafka/connect-distributed.properties 파일 마지막 아래 plugin 정보 추가
  - Plugin.path=[confluentinc-kafka-connector-dbc-10.0.1 폴더]

```yaml
plugin.path=/Users/Desktop/kafka/confluentic-kafka-connect-jdbc-10.0.1/lib
```

- JdbcSourceConnector에서 MariaDB 사용하기 위해 mariadb드라이버 복사
  - ./share/java/kafka/ 폴더에 mariadb-java-client-2.7.2.jar 파일 복사
