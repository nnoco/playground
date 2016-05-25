// range.js: 값 범위를 나타내는 클래스

// 예제 6-1 특정 프로토타입을 상속받는 객체 생성하기
// inherit()은 프로토타입 객체 p의 속성을 상속받아 새롭게 생성된 객체를
// 반환한다. 만일 ECMAScript 5 함수인 Object.create()가 정의되어 있다면
// 해당 함수를 사용할 수 있다.
// 하지만 사용할 수 없는 경우에는 예전 방법을 사용한다.
function inherit(p) {
	if (p == null) throw TypeError();
	if (Object.create)
		return Object.create(p);
	var t = typeof p;

	if ( t !=="object" && t !== "function") throw TypeError();
	function f() {};
	f.prototype = p;
	return new f();
}

// range 객체를 반환하는 팩토리 함수
function range(from, to) {
	// 아래에 정의한 rnage.methods 프로토타입 객체를 상속하는
	// 객체를 생성하기 위해 inherit() 함수를 사용한다.
	// range.methods 프로토타입 객체는 이 함수의 프로퍼티로 저장되고
	// 모든 rnage 객체가 공유하는 메서드를 정의하고 있다.
	var r = inherit(range.methods);

	// 이 range 객체의 시작과 끝을 (객체의 상태로) 저장한다.
	// 이 프로퍼티들은 해당 객체의 고유한 값이고 상속되지 않는다.
	r.from = from;
	r.to = to;

	return r;
}

// 이 포로토타입 객체는 모든 range 객체가 상속하늠 메서드를 정의한다.
range.methods = {
	// x 값이 범위 내에 있다면 true를, 그렇지 않으면 false를 반환한다.
	// 이 메서드는 텍스트 범위나 날짜 범위에 대해서도 숫자 범위와 마찬가지로 작동한다.
	includes: function(x) { return this.from <= x && x <= this.to; },
	// 범위 내의 각 정수에 대해 f를 한 번씩 호출한다.
	// 이 메서드는 숫자 범위에 대해서만 작동한다.
	foreach: function(f) {
		for(var x = Math.ceil(this.from); x <= this.to; x++) f(x);
	},
	// 범위를 표현하는 문자열을 반환한다.
	toString: function() { return "(" + this.from + "..." + this.to + ")"}
};

// range 객체를 사용하는 몇 가지 예제들.
var r = range(1, 3);
r.includes(2);
r.foreach(console.log);
console.log(r);