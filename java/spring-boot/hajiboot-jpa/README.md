JPA는 JPQL뿐만 아니라 SQL도 사용할 수 있다. 스프링 데이터 JPQ에서 다음과 같이 @Query에 nativeQuery=true를 지정하면 SQL을 사용할 수 있다.
```
@Query(value = "SELECT id, first_name, last_name, FROM customers ORDER BY fisrt_name, last_name", nativeQuery = true)
List<Customer> findAllOrderByName();
```
그러나 이렇게 SQL을 사용한다면 JPA의 장점을 활용할 수 없다. 기본으로 JPQL을 사용하고, 벤더에 의존하는 구문을 꼭 사용해야 하는 복잡한 쿼리를 기술할 때만 SQLd 사용하면 된다.