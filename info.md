# 스프링 웹 개발 기초

- ### 정적 컨텐츠
    - html과 같이 아무런 변형 없이 그대로 보여주는 것
- ### MVC와 템플릿 엔진
    - 어떠한 변형을 통해서 화면을 구성
- ### API
    - 특정 데이터포맷으로 데이터를 전달 해주는 방식


- ### 웹 브라우저에서 request 요청이 들어올 경우
    1. 톰켓으로 요청 들어옴
    2. 톰켓 -> 스프링 컨테이너
    3. 해당 controller를 찾아서 실행
        1. controller에 있는 mapping일 경우는 해당 `controller를 실행`
        2. 만약 없는 경우는 `html과 같은 resources 내부에 있는 정적 파일을 찾는다.`
        3. `@ResponseBody` 어노테이션을 사용한 경우 데이터만을 반환한다.
            1. 이때 사용되는 것이 messageConverter

- ### messageConverter
    - 기본 타입은 `json`
    - Spring에서 기본타입으로 사용중
    - String의 경우 `StringHttpMessageConverter`
    - 객체의 경우 `MappingJackson2HttpMessageConverter`
        - json converter lib를 지원하는 회사중 spring에서 사용하는 라이브러리는 jackson사 이다
    - accept 헤더 : HttpMessageConverter 타입 선택시 활용

- ## Srping 의존성 주입(Dependency Injection)
    - spring 에는 스프링 컨테이너라고 하는 메모리 공간이 있다
    - 기본적인 셋팅은 싱글톤 컨테이너 이다
        - 하나의 메모리에서 관리하는 방법 - 하나의 객체를 사용함으로써, 같은 메모리를 공유한다
        - 특별한 경우를 제외하고는 기본적으로 싱글톤을 사용한다.
    - 스프링 빈을 등록하는 방법에는 2가지가 있다
        1. 컴포넌트 스캔(@Component), 의존관계 주입 (@Autowired) - //빈(bean) - 객체를 부르는 말
            - @Component, @Autowired 어노테이션을 사용하여서 스프링 컨테이너에 빈을 생성하고 관리한다.
        2. 자바 코드로 직접 등록 - SpringConfig.java 파일 참조
            - 정형화된 컨트롤러, 서비스, 레포지토리는 컴포넌트 스캔을 사용하는 것이 더 편리
            - 하지만 정형화되지 않고, 때에따라서 구현클래스를 변경해야한다면 설정을 하는것이 좋다
    - @Autowired를 통한 의존성 주입(DI)는 스프링 컨테이너에 등록되어 있는 경우에만 작동한다
    - 이처럼 사용하는 파일 내부가 아닌 외부에서 설정되는 것을 `IOC` 라고 한다

  ```
  @Controller 어노테이션이 있으면 스프링 빈으로 자동등록된다 
  그 이유는 @Controller 어노테이션 내부에 @Component가 있기 때문이다
  @Controller 뿐 아니라 @Service, @Repository도 @Component를 가지고 있다

  ** @Autowired의 경우 생성자가 하나만 존재한다면, 생략 가능하다.
  ```
