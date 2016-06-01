스프링 부트는 자동 설정(Auto configuration)을 통해 DataSource나 JdbcTemplate, NamedParameterJdbcTemplate을 자동으로 생성하여 DI 컨테이너에 등록한다. 따라서 스프링 부트에서는 의존 라이브러리에 spring-boot-jdbc와 JDBC 드라이버만 추가하면 다른 설정을 하지 않아도 JdbcTemplate을 사용할 수 있다.    
`??` 만약 드라이버의 종류가 여러가지인 경우에는 어떻게 되는거지..? 우선순위가 있나? 처리방법을 따로?  
  
스프링부트에서는 클래스 패스 아래에 다음과 같은 SQL 파일이 존재하면 그것을 읽어들여 실행한다.
- schema-플랫폼.sql
- schema.sql
- data-플랫폼.sql
- data.sql
'플랫폼' 부분의 기본 값은 all이며, 애플리케이션을 시작할 때 `--spring.datasource.platform=xxx`를 지정하여 변경할 수 있다.  
  
SQL 파일에 한국어를 사용하려면 src/main/resources/application.yml 파일에 다음처럼 파일의 문자 코드 종류를 지정해야한다.
```
spring.datasource.sqlScriptEncoding: UTF-8
```
  
