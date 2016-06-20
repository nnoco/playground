/*
process.nextTick(callback)을 활용한 작업 스케줄링
이벤트 루프의 다음 사이클에서 작업을 수행하도록 스케줄링 한다.
setImmediate() 함수와는 달리 nextTick()은 I/O 이벤트가 발생하기 전에 실행되기 때문에
I/O 이벤트의 기아현상(starvation)을 발생시킬 수 있다.
Node.js는 기본 값 1000으로 설정된 process.maxTickDepth 값을 기준으로
각 사이클에 실행될 nextTick() 이벤트의 수를 제한한다.
*/

var fs = require("fs");
fs.stat("nexttick.js", function(err, stats) {
	if(stats) { console.log("nexttick.js Exists"); }
});
setImmediate(function() {
	console.log("Immediate Timer 1 Executed");
});
setImmediate(function() {
	console.log("Immediate Timer 2 Executed");
});
process.nextTick(function() {
	console.log("Next Tick 1 Executed");
});
process.nextTick(function() {
	console.log("Next Tick 2 Executed");
});