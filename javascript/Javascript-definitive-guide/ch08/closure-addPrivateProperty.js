/*
이 함수는 프로퍼티 접근 메서드를 객체 o의 프로퍼티에 특정 이름으로 추가한다.
// 메서드 이름은 get<name>과 set<name>이 된다.
만약 단정(predicate) 함수가 제공되면 setter 메서드는 전달된 인자를 저장하기 전에
인자 유효성을 테스트하기 위해 단정 함수를 사용한다.
만약 단정 함수가 false를 반환하면 setter 메서드는 예외를 발생시킨다.

이 함수에 대해 일반적이지 않은 사항은 getter/setter 메서드에 의해 처리된 프로퍼티 값이
객체 o에 저장되지 않는 것이다. 대신, 그 값은 오직 이 함수의 지역 변수로만 저장된다.
또한 getter.setter 메서드는 이 함수 내부에 지역적으로 정의되기 때문에 이 함수의 지역 변수에
setter 메서드를 통하지 않고서는 설정되거나 수정될 수 없다는 뜻이다.
*/
function addPrivateProperty(o, name, predicate) {
	var value; // 프로퍼티 값
	
	// getter 메서드는 단순히 value를 반환한다.
	o["get" + name] = function() { return value; };

	// setter 메서드는 value를 저장하거나
	// 단정 함수가 값을 적합하지 않다고 판단하면 예외를 발생시킨다.
	o["set" + name] = function(v) {
		if (predicate && !predicate(v)) {
			throw Error("set" + name + ": 유효하지 않은 값 " + v);
		} else {
			value = v;
		}
	};
}

// 다운 코드는 addPrivateProperty() 메서드를 사용하는 방법을 보여준다.
var o = {};

// 프로퍼티 접근 메서드 getName과 setName()을 추가한다.
// setName이 문자열 값만 허용하는지 확인한다.
addPrivateProperty(o, "Name", function(x) { return typeof x == "string"; });

o.setName("Frank");
console.log(o.getName());
o.setName(0);