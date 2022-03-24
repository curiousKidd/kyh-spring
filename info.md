## 스프링 웹 개발 기초

- 정적 컨텐츠
    - html과 같이 아무런 변형 없이 그대로 보여주는 것
- MVC와 템플릿 엔진
    - 어떠한 변형을 통해서 화면을 구성
- API
    - 특정 데이터포맷으로 데이터를 전달 해주는 방식


- 웹 브라우저에서 request 요청이 들어올 경우
    1. 톰켓으로 요청 들어옴
    2. 톰켓 -> 스프링 컨테이너
    3. 해당 controller를 찾아서 실행
        1. controller에 있는 mapping일 경우는 해당 `controller를 실행`
        2. 만약 없는 경우는 `html과 같은 resources 내부에 있는 정적 파일을 찾는다.`
        3. `@ResponseBody` 어노테이션을 사용한 경우 데이터만을 반환한다.
            1. 이때 사용되는 것이 messageConverter

- messageConverter
    - 기본 타입은 `json`
    - Spring에서 기본타입으로 사용중
    - String의 경우 `StringHttpMessageConverter`
    - 객체의 경우 `MappingJackson2HttpMessageConverter`
        - json converter lib를 지원하는 회사중 spring에서 사용하는 라이브러리는 jackson사 이다
    - accept 헤더 : HttpMessageConverter 타입 선택시 활용
