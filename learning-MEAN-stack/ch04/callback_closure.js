// 비동기 콜백에서 필요한 변수를 클로저에 제공하기 위한 래퍼 함수 생성 부분
function logCar(logMsg, callback) {
	process.nextTick(function() {
		callback(logMsg);
	});
}
var cars = ["Ferrari", "Porsche", "Bugatti"];
for (var idx in cars) {
	var message = "Saw a " + cars[idx];
	logCar(message, function() {
		console.log("Normal Callback: " + message);
	});
}
for (var idx in cars) {
	var message = "Saw a " + cars[idx];
	(function(msg) {
		logCar(msg, function() {
			console.log("Closure Callback: " + msg);
		})
	})(message);
}