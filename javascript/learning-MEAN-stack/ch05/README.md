빅 엔디언과 리틀 엔디언  
빅 엔디언은 최소워드를 처음에, 리틀 엔디언은 최소 워드를 마지막에
  
---
버퍼 객체는 실제 기본 메모리를 할당하기 때문에 생성 시 크기를 지정해야 한다. 
new 키워드를 이용해 Buffer 객체 생성 시에 세 가지 옵션이 있다.
```
new Buffer(sizeInBytes)
new Buffer(octetArray)
new Buffer(String, [encoding])
  
---
버퍼에 쓰기  
Buffer에 객체를 생성하고 난 후에는 객체의 크기를 변경할 수는 없지만, 버퍼 내 어느 위치에든 쓸 수 있다.
- buffer.write(string, [offset], [length], [encoding]) : 버퍼에 지정된 위치, 크기, 인코딩의 string을 쓴다.
- buffer[offset] = value : offset 위치의 데이터를 지정된 value의 값으로 교체한다.
- buffer.fill(value, [offset], [end]) : 버퍼의 지정된 offset 위치에서 end 위치까지 지정된 value로 모든 바이트를 쓴다.
- writeInt8(value, offset, [noAssert]), writeInt16LE, writeInt16BE
  
---
버퍼에서 읽기
- buffer.toString([encoding], [start], [end])
- stringDecoder.write(buffer)
- buffer[offset]
- readInt8(offset, [noAssert]), readInt16LE(...), readInt16BE(...)

  
# 스트림
Node.js의 중요한 모듈 중에 하나로 Stream 모듈이 있다. 데이터 스트림은 읽기, 쓰기, 읽기/쓰기가 가능한 메모리 구조다. Node.js에서 스트림은 파일 접근이나
HTTP 요청으로 데이터를 읽을 때를 포함한 많은 부분에 사용된다.  
스트림을 사용하는 목적은 데이터 전송을 위한 공통 구조를 제공하기 위해서다. 스트림에서 데이터가 읽기 가능한 상태가 되면 data 이벤트가 발생하고, 오류가 발생하면 error
이벤트가 생성된다. 스트림에서 데이터를 처리하기 위한 리스너를 등록해 사용할 수도 있다.  
스트림은 HTTP 데이터나 파일을 위해 일반적으로 사용한다. 파일을 읽기 가능한 스트림으로 열거나 HTTP 요청을 읽기 가능한 스트림으로 만들어 필요한 정보를 읽을 수 있다. 추가적으로 커스텀 스트림을 만들어 사용할 수도 있다.  
  
## Readable 스트림
Readable 스트림은 다른 리소스로부터 애플리케이션으로 데이터를 쉽게 읽어 들일 수 있는 구조를 제공하기 위해 디자인됐다. Readable 스트림의 일반적인 예는 다음과 같다.
- 클라이언트의 HTTP 응답
- 서버의 HTTP 요청
- fs 읽기 스트림
- zlib 스트림
- crypto 스트림
- TCP sockets
- 자식 프로세서 stdout과 stderr
- process.stdin
  
Readable스트림은 데이터를 읽기 위해 read([size]) 함수를 제공한다. size는 스트림에서 읽을 바이트의 크기를 지정한다. read()는 String 객체나 Buffer 객체, null을 반환한다.
Readable 스트림은 다음 이벤트를 생성한다.
- readable: 스트림에서 데이터 청크를 읽을 수 있을 때 생성
- data: 데이터 이벤트 핸들러가 추가된 것을 제외하면 readable과 유사
- end: 스트림에 데이터가 더 이상 제공되지 않을 때 생성된다.
- close: 파일 같은 기본 리소스가 닫힐 때 생성된다.
- error: 데이터를 수신 시 오류가 발생한 경우 생성
  
Readable 스트림 객체는 읽거나 조작을 위한 다양한 함수를 제공한다.
- read([size]): 스트림에서 String이나 Buffer, null 형태의 데이터를 읽음(null은 더 이상 읽은 데이터가 남아있지 않는 것을 의미함). size 전달인자를 지정한 경우 읽는 데이터의 크기가 제한
- setEncoding(encoding): read() 요청 결과를 String 형태로 반환 시 인코딩 형태
- pause(): 객체에서 생성되는 data 이벤트를 중지
- resume(): 객체에서 생성되는 data 이벤트를 재개
- pipe(destination, [option]): 출력 스트림을 destination 필드에 지정된 Writable 스트림 객체에 연결.
- unpipe([destination]): Writable 목적 스트림에서 객체 제거
  
## Writable 스트림
Writable 스트림은 데이터를 스트림에 쓰기 위한 write(chunk, [encoding], [callback]) 함수를 제공한다. chunk에는 쓰여질 데이터를 말하고, encoding은 문자열 인코딩, callback은 데이터를 성공적으로 썼을 때 수행할 콜백 함수를 지정한다.
`write()` 함수는 데이터가 성공적으로 쓰이면 true를 반환한다. Writable 스트림은 다음 이벤트를 발생한다.
- drain: write() 호출이 false를 반환한 이후 다시 데이터를 쓰기 가능한 상태라는 것을 리스너 함수에 알려주기 위해 사용한다.
- finish: 모든 데이터가 비워지고 더 이상 쓸 데이터가 없는 경우 Writable 객체에 end()가 호출된 후 생성된다.
- pipe: Readable 스트림에 Writable 목적지가 추가되면 pipe() 함수 호출 후 생성된다.
- unpipe: Readable 스트림에서 Writable 목적지제거를 위해 unpipe() 호출 후 생성된다.