# Spring Boot

# Spring web 계층

## Web Layer
+ 흔히 사용하는 컨트롤러와 뷰 템플릿 계층
+ 이외에도 필터, 인터셉터, 컨트롤러 어드바이스 등 외부 요청과 응답에 대한 전반적인 영역

## Service Layer
+ @Service에 사용되는 서비스 영역입니다.
+ 일반적으로 Controller 와 Dao의 중간 영역에서 사용
+ @Transactional 이 사용되어야 하는 영역

## Repository Layer
+ database와 같이 데이터 저장소에 접근하는 영역
+ 기존의 dao 영역으로 이해하면 된다.

### Dtos
+ Dto(Data Transfer Object)는 계층 간에 데이터 교환을 위한 객체, Dtos는 이들의 영역

### Domain Model
+ 도메인이라 불리는 개발 대상을 모든 사람이 동일한 관점에서 이해 할 수 있고 공유 할 수 있도록 단순화 시킨 모델
+ @Entity 가 사용되는 영역
+ 다만, 무조건 데이터베이스의 테이블과 관계가 있어야만 하는것은 아니다.
+ VO처럼 값 객체들도 이 영역에 해당.
+ @Entity 클래스를 기준으로 테이블이 생성되고, 스키마가 변경된다.

=> 이 5개의 레이어에서 비지니스 처리를 담당해야 할곳은 어디?
=> Domain .

=> Springframework MVC 기존의 방식에서는 Controller Service Dao 에서 Service에서 비지니스 로직을 처리하였다. 이 방식을 트랜잭션 스크립트라고 하고 사실상 서비스 계층은 무의미 하고 , 객체란 단순히 데이터 덩어리만 의미했다.

=> 도메인 모델에서는 Service 는 트랜잭션과 도메인 간의 순서만 보장해준다.


### 모데인 모델 방식에서는 bean을 주입할 때 @AutoWried를 사용하지 않는 방법도 있다.

=> bean 주입을 @Autowired 나 setter 가 아닌 생성자로 주입하는 방식을 사용
=> @RequiredArgsConstructor 에서 해결해준다.
=> 해당 클래스의 의존성 관계가 변경될 때마다 생성자 코드를 계속해서 수정하는 번거로움이 해결된다.

```java
@RequiredArgsConstructor // final 붙은 인자만 생성자 생성 -> 또다른 bean 주입
@RestController
public class PostsApiController {
	
	private final PostsService postsService;
	
	@PostMapping("/api/v1/posts")
	public Long save(@RequestBody PostsSaveRequestDto requestDto) {
		return postsService.save(requestDto);
	}

}
```
==> 하지만 단점도 있다.
