// range2.js: 값 범위를 표현하는 또 하나의 클래스

// 이 함수는 새 Rnage 객체를 초기화하는 생성자 함수다.
// 이 함수는 어떤 객체도 내부에서 생성하고 반환하지 않는다. 단지 this를 초기화할 뿐이다.
function Range(from, to) {
	// 이 Range 객체의 시작과 끝을 (객체의 상태로) 저장한다.
	// 이 프로퍼티들은 해당 객체의 고유한 값이고 상속되지 않는다.
	this.from = from;
	this.to = to;
}

// 모든 Range 객체는 이 객체를 상속한다.
// 모든 객체가 이 객체를 상속하려면, 프로퍼티 이름은 반드시 "prototype"이어야 한다.
Range.prototype = {
	// x 값이 범위 내에 있다면 true를, 그렇지 않으면 false를 반환한다.
	// 이 메서드는 텍스트 범위 및 날짜 범위에 대해서도 숫자 범위와 마찬가지로 작동한다.
	includes: function(x) { return this.from <= x && this.to; },
	// 범위 내의 각 정수에 대해 f를 한 번씩 호출한다.
	// 이 멧허드는 숫자 범위에 대해서만 작동한다.
	foreach: function(f) {
		for(var x = Math.ceil(this.from); x <= this.to; x++) f(x);
	},
	// 범위를 표현하는 문자열을 반환한다.
	toString: function(I) { return "(" + this.from + "..." + from.to + ")"; }
};

// Range 객체를 사용하는 몇 가지 예제들.
var r = new Range(1, 3);
r.includes(2);
r.foreach(console.log);
console.log(r);
console.log(r.from + ". " + r.to);