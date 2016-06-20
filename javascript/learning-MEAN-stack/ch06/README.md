# 6. Node.js에서 파일 시스템 접근
동기적/비동기적 파일 시스템 호출의 차이
- 비동기 호출은 추가 전달인자로 콜백함수가 필요하다. 콜백 함수는 파일 시스템 요청이 완료된 후 실행되고 마지막 전달인자로 오류 메시지를 포함한다.
- 비동기 호출은 자동으로 예외처리를 하고 오류 객체를 첫 전달인자로 전달한다. 동기적 호출 방식에서는 반드시 try/catch 블록을 사용해 예외처리를 한다.
- 동기 호출은 바로 실행되고 수행이 완료될 때까지 제어가 현재 스레드로 반환되지 않는다. 비동기 호출은 이벤트 큐에 위치된 후 제어가 바로 수행 중이던 코드로 반환된다. 실제 파일 시스템 호출은 이벤트 큐에서 선택된 이후 수행된다.
  
---
### 파일 열기 및 닫기
열린 파일 상태 지정
- r: 읽기 가능 파일 열기, 파일이 존재하지 않으면 예외 발생
- r+: 읽기 쓰기 가능 파일 열기. 파일이 존재하지 않으면 예외 발생
- rs: 동기 모드로 읽기 가능 파일 열기. fs.openSync()와는 동일하지 않다. 사용 시 로컬 파일 시스템 캐시를 통과한다. NFS 마운트의 경우 오래된 로컬 캐시가 존재하지 않도록 만들기 때문에 유용. 시스템 성능 저하를 가져올 수 있기 때문에 플래그 사용에 주의.
- rs+: 읽기 쓰기가 동시에 가능하게 연다는 것을 제외하고 rs와 동일
- w: 쓰기 가능 파일 열기. 파일이 존재하지 않는 경우 새로 생성, 존재하는 경우 기존 내용 제거
- wx: 기존 경로가 존재할 경우에 실패, w와 나머지 동일
- w+: 읽기 쓰기 가능 파일 열기. 파일이 존재하지 않는 경우 생성. 존재하는 경우 기존 내용 제거
- wx+: 기존 경로가 존재할 경우에 실패,w+와 동일
- a: 추가를 위한 파일 열기, 파일이 존재하지 않으면 생성
- ax: 기존 경로가 존재할 경우에 실패, a와 동일
- a+: 읽기, 추가를 위한 파일 열기, 파일이 존재하지 않으면 생성
- ax+: 경로가 존재하는 경우에 실패, a+와 동일
  
---
### 동기 파일 쓰기  
동기적 파일 쓰기를 위해선 openSync()를 사용해 파일 디스크립터를 얻은 후 fs.writeSync()를 사용해 파일에 데이터를 쓰고, fs.closeSync()로 종료한다.  
`fs.writeSync(fd, data, offset, length, position);`  
  
### 비동기 파일 쓰기  
open()을 사용해 파일을 열고 콜백 함수 수행 후에 fs.write()를 사용해 파일에 데이터를 쓴다. fs.write()를 사용하는 문법은 아래와 같다.  
`fs.write(fd, data, offset, length, position, callback)`  
  
### 스트리밍 파일 쓰기  
대량 데이터를 파일에 쓰기 위해 가장 효율적인 방법 중 하나는 파일을 열어서 Writable 스트림으로 사용하는 스트리밍이다. Writable 스트림은 간단히 구현이 가능하고, pipe() 함수를 사용해 Readable 스트림과 간단히 연결 가능하다. 이 방식을 사용해 HTTP 요청과 같은 Readable 스트림 소스에서 매우 간편히 데이터를 쓸 수 있다.  
```
fs.create(path, [options]);
// path는 절대 경로 또는 상대 경로
// options 인자에는 encoding과 mode, flag 속성을 지정
```
Writable 파일 스트림을 한 번 열면 표준 스트림 write(buffer) 함수를 사용해 파일을 쓴다. 쓰기를 마치면 end() 함수를 사용해 스트림을 닫는다.
  
---
## 파일 읽기
fs 모듈은 파일 읽기를 위한 네 가지 다른 방식(하나의 큰 청크 사용, 동기 읽기를 사용한 청크 사용, 비동기 읽기를 사용한 청크 사용, Readable 스트림을 통한 스트리밍)을 제공한다. 네 가지 방식 모두 효과적이기 때문에 사용하는 애플리케이션의 요구에 맞게 사용하면 된다.
  
### 간단한 파일 읽기
```
fs.readFile( path, [options], callback )
fs.readFileSync( path, [options] )
```
  
### 동기적 파일 읽기
```
var fd = fs.openSync();
fs.readSync(fd, buffer, offset, length, position)
fs.closeSync(fd);
```
  
### 비동기적 파일 읽기
```
var fd = fs.open();
fs.read(fd, buffer, offset, length, position, callback);
fs.close(fd);
```
  
### 스트리밍 방식 파일 읽기
많은 양의 데이터를 파일에서 읽는 최적의 방법은 파일을 Readable 스트림으로 읽는 파일 스트리밍 방식을 사용하는 것이다. pipe() 함수를 사용하면 Readable 스트림과 Writable 스트림을 간단히 연결할 수 있다. 이를 활용해 HTTP 응답 구현 같은 목적으로, 파일에서 읽은 데이터를 Writable 스트림 소스로 아주 간편히 주입할 수 있다.  
```
fs.createReadStream( path, [options] )
```
  
---
## 기타 파일 시스템 작업
### 경로가 있는지 확인
```
fs.exist(path, function (exists) {
	...
});
var exists = fs.existsSync(path);
```
  
### 파일 정보 확인
```
fs.stat(path, callback);
fs.statSync(path);
```
Stats 객체의 속성과 함수
- isFile()
- isDirectory()
- isSocket()
- dev: 파일이 위치한 곳의 디바이스 ID
- mode: 파일 접근 모드 지정
- size: 파일 크기 지정
- blksize: 파일 저장에 사용된 바이트 단위의 블록 크기 지정
- blocks: 파일이 디스크 상에서 차지하는 블록 크기 지정
- atime: 마지막 파일 접근 시간 지정
- mtime: 마지막 파일 변경 시간 지정
- ctime: 파일 생성 시간 지정
  
### 파일 목록
```
fs.readdir(path, callback);
fs.readdirSync(path);
```
  
### 파일 삭제
```
fs.unlink(path, callback);
fs.unlinkSync(path);
```
  
### 파일 잘라내기  
파일 잘라내기는 파일 끝 위치를 현재보다 작게 만들어 파일 크기를 줄이는 것을 의미
```
fs.truncate(path, len, callback);
fs.truncateSync(path, len);

// new.txt 파일의 크기를 0byte로 잘라내기
fs.truncate("new.txt", function(err) {
	console.log(err ? "File Truncate Failed" : "File Truncated");
});
```
  
### 디렉토리 추가와 삭제
```
fs.mkdir(path, [mode], callback);
(boolean) fs.mkdirSynk(path, [mode]);
fs.rmdir(path, callback);
(boolean) fs.rmdir(path);
```
  
### 파일 이름과 디렉토리 이름 변경
```
fs.rename(oldPath, newPath, callback);
(boolean) fs.renameSync(oldPath, newPath);

fs.rename("old.txt", "new.txt", function(err) {
	console.log(err ? "Rename Failed" : "File Renamed");
});
```
  
### 파일 변경 내역 관찰
아직 안정적인 기능은 아니지만 fs 모듈은 파일 상태를 관찰할 수 있는 기능을 제공한다. 이 기능은 애플리케이션이 지속적인 폴링을 통해 파일의 상태를 확인하지 않고도 파일 변경에 따른 이벤트를 발생시킬 수 있다. 운영체제에 따라서 오버헤드가 발생할 수 있으므로 주의.
```
var options = {
	persistent: boolean, // 파일 관찰 동안 프로세스가 지속적으로 수행되길 원하는 경우
	interval: milliSeconds // 폴링 간격
}

fs.watchFile(path, [options], callback);

fs.watchFile('log.txt', options, function (curr, prev) {
	console.log('log.txt modified at: ' + curr.mtime);
	console.log("Previous modification was: " + prev.mtime);
})