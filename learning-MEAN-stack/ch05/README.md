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