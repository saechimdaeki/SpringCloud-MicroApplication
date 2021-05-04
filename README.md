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

