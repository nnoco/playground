Node.js의 블로킹 I/O
- 파일 읽기
- 데이터베이스 질의
- 소켓 요청
- 원격 서비스 접속

  
---
Node.js는 블로킹 I/O로 인한 지연을 피하고자 이벤트 콜백을 사용한다. 그래서 블로킹 I/O를 수행한 어떤 요청이든 백그라운드이 다른 스레드에서 수행된다. Node.js는 백그라운드에서 스레드 풀을 구현했다. 이벤트 큐에서 이벤트나 블록 I/O 이벤트가 얻어지면 Node.js는 메인 이벤트 루프 스레드가 아닌, 스레드 풀에서 스레드 한 개를 꺼내어 해당 함수를 수행한다. 이런 구조로 인해 이벤트 큐 내에 모든 잔여 이벤트들의 블로킹 I/O를 방지할 수 있다.
  

### Node.js 애플리케이션은 다음 함수들을 사용해 콜백 함수를 이벤트 큐의 작업으로 등록 가능하다.
- 파일을 작성하거나 데이터베이스에 연결하는 등의 블로킹 I/O 라이브러리 호출을 사용
- http.request나 server.connection 과 같은 빌트인 이벤트에 이벤트 리스너를 추가
- 이벤트 이미터<super>emitter</super>를 작성해 고유한 리스너를 추가
- process.nextTick 옵션을 사용해 다음 이벤트 루프 사이클에 선택될 작업을 스케줄링
- 타이머를 사용해 특정 시간 이후나 주기적인 간격으로 작업을 스케줄링
  
  
### 이벤트 다루기
자바 스크립트 객체에 커스텀 이벤트 추가
```
var events = require("events");
var emitter = new events.EventEmitter();
emitter.emit("simpleEvent");
```
  
자바스크립트 객체에 직접 이벤트 추가
```
function MyObject() {
	events.EventEmitter.call(this);
}
MyObject.prototype.__proto__ = events.EventEmitter.prototype;
```
  
이벤트 리스너를 객체에 추가
- addListener(eventName, callback)
- .on(eventName, callback) : addListener()와 동일
- .once(eventName, callback); : 이벤트가 트리거되면 한번 콜백함수 실행
  
객체에서 리스너를 제거
- listeners(eventName) : eventName 이벤트에 추가된 리스너 함수 배열을 반환한다.
- .setMaxListeners(n) : EventEmitter에 n 보다 많은 리스너가 추가된 경우 경고를 터리거한다. 기본 값 10
- .removeListener(eventName, callback) : EventEmitter의 eventName 이벤트에 등록된 콜 함수를 제거
