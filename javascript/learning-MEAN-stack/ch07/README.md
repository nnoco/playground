## URL 객체
```
url.parse(urlStr, [parseQueryString], [slashesDenoteHost])
url.format(urlObj);

var url = require('url');
var urlStr = 'http://user:pass@host.com:80/resourse/path?query=string#hash';
var urlObj = url.parse(urlStr, true, false);
var urlString = url.format(urlObj);
```

url.parse() 결과 URL 객체 속성
- href: 파싱할 URL 전체 문자열
- protocol
- host
- auth
- hostname
- port
- pathname
- search
- path
- query
- hash

  

## 요청, 응답, 서버 객체 이해
http 모듈을 사용하려면 우선 요청 객체(RequestObject)와 응답 객체(ResponseObject)를 이해해야 한다. 이 객체들은 정보와 함께 HTTP 클라이언트와 서버의 많은 기능을 제공한다. 속성 값과 이벤트, 함수를 포함한 객체의 구성을 잘 이해하면 간단하게 HTTP 서버와 클라이언트를 구현할 수 있다.
### http.ClientRequest 객체
ClientRequest 객체는 HTTP 클라이언트 구성을 위해 http.request() 호출 시 내부적으로 생성
```
var http = require('http');
var options = {
	hostname: 'www.myserver.com',
	path: '/',
	port: '8080',
	method: 'POST'
};
var req = http.request(options, function(response) {
	var str = '';
	response.on('data', function(chunk) {
		str += chunk;
	});
	response.on('end', function() {
		console.log(str);
	});
});
```
ClientRequest 객체 생성 시 옵션
- host
- hostname
- port
- localAddress: 네트워크 연결을 위해 바인드 되는 로컬 인터페이스
- socketPath: 유닉스 도메인 소켓(host:port 또는 socketPath 형태로 사용)
- method
- path
- headers: {'content-length': 750, 'content-type': 'text/plain'}
- auth: Authorization 헤더 'user:password'
- agent: Agent 동작 정의 Agent가 사용된 경우 요청의 기본 값은 Connection:keep-alive. 가능한 값은 다음과 같다.
    - undefined(default): 전역 Agent 사용
    - Agent: 특정 Agent 객체 사용
    - false: Agent 동작 비활성화.
  
ClientRequest 이벤트
- response
- socket: 요청에 대한 소켓이 할당된 경우
- connect: CONNECT 방식을 사용한 요청 초기화에 서버가 응답한 경우 매번 발생. 이벤트가 클라이언트에서 처리되지 않은 경우엔 연결이 닫힌다.
- upgrade: 갱신 요청을 포함한 헤더를 가진 요청에 서버가 응답한 경우
- continue: 서버가 100 Continue라는 HTTP 응답을 보내 클라이언트에게 body를 포함해 요청을 보내도록 지시할 때
  
ClientRequest 객체의 메서드
- write(chunk, [encoding])
- end([data], [encoding])
- abort()
- setTimeout(timeout, [callback])
- setNoDelay([noDelay]): 데이터를 보내기 전에 저장하는 Nagle 알고리즘을 비활성화한다. noDelay는 boolean으로 즉시 쓰기의 경우 true, 버퍼 방식의 경우 false
- setSocketKeppAlive([enable], [initialDelay]): 클라이언트 요청의 keep-alive 기능을 활성화하거나 비활성화한다.  enable 전달인자의 기본 값은 비활성화 상태인 false. initialDelay 전달인자는 마지막 데이터 패킷과 첫 keep-alive 요청 사이의 지연 시간을 지정한다.
  
### ServerResponse 객체 이벤트와 속성
- close
- headerSent
- sendDate
- statusCode: response.statusCode = 500;

### ServerResponse 메서드
- writeContinue(): 클라이언트에 HTTP/1.1 100 Continue 메시지를 보내어 본문 데이터가 계속 전송되기를 요청한다.
- writeHead(statusCode, [reasonPhrase], [headers]): 요청에 대한 응답 헤더를 쓴다. 
- setTimeout(msecs, callback): 클라이언트 연결을 위한 소켓의 밀리초 단위의 타임아웃 시간 설정, callback은 타임아웃 발생 시 수행되는 함수
- setHeader(name, value)
- getHeader(name)
- removeHeader(name)
- write(chunk, [encoding])
- addTrailers(headers): 응답 끝에  HTTP 트레일링 헤더를 추가
- end([data], [encoding]): 응답 body에 선택적인 데이터를 작성하고 Writable 스트림을 비운 후 응답을 마무리.
  
### http.IncomingMessage 객체
HTTP 서버나 HTTP 클라이언트는 IncomingMessage 객체를 생성. 서버 단에서는 클라이언트의 요청이 IncomingMessage 객체가 되고 클라이언트 단에서는 서버의 응답이 IncomingMessage 객체가 된다. 클라이언트와 서버의 IncomingMessage 객체가 동일하게 사용되는 이유는 양 단의 기본 동작이 동일하기 때문이다.  
IncomingMessage는 Readable 스트림을 만들기 때문에 클라이언트의 요청이나 서버의 응답을 처리하는 스트리밍 소스로 활용할 수 있다. 즉, readable, data 이벤트를 받을 수 있어 스트림 데이터를 읽는 곳에 사용할 수 있다.  
Readable 클래스에서 제공하는 기능 외에도, IncomingMessage 객체는 아래와 같은 속성, 이벤트, 함수를 제공한다.
- close: 소켓 종료 시 이벤트 발생.
- httpVersion: 클라이언트 요청/응답 생성에 사용된 HTTP 버전을 지정
- headers: 헤더에 포함된 객체
- trailers: 트레일러 헤더 객체
- method
- url
- statusCode
- socket
- setTimeout(msecs, callback)

## HTTP Server 객체
Server 객체 이벤트
- request: 서버가 클라이언트 요청 수신 시 매번 발생. `callback(request, response){}`
- connection: 새로운 TCP 연결 수립 시 발생 `callback (socket) {}`
- close
- checkContinue: Expect: 100-continue 헤더가 포함된 요청 수신 시 발생 `callback (request, response)`
- connect: `callback(request,socket,head)`
- upgrade : `callback(request,socket,head)`
- clientError: 클라이언트 연결 소켓 오류 발생 시 발생. callback은 첫 전달인자로 error로 받고 두 번째 전달 인자로 socket을 사용한다. `callback(error, socket){}`
  

### HTTP 서버 시작
```
var http = require('http');
var server = http.createServer([requestListener])
server.listen([port, [hostname], [backlog], [callback]]);
```
- port : 수신할 포트
- hostname: 연결을 수락할 hostname 생략된 경우 모두 수락
- backlog: 큐에 허용된 지연 연결의 최대 개수 지정, 기본값 511
- callback: 서버가 지정된 포트로 수신 시작 시 실행할 콜백 핸들러 지정
  
```
var http = require('http');
http.createServer(function (req, res) {
	// handle request
}).listen(8080);
