/*
Interval 타이머로 주기적 작업 수행
인터벌 타이머를 사용하면 지정된 지연 간격에 맞춰 작업을 수행하게 할 수 있다.
*/
var x=0, y=0, z=0;
function displayValues() {
	console.log("X=%d, Y=%d, Z=%d", x, y, z);
}
function updateX() {
	x += 1;
}
function updateY() {
	y += 1;
}
function updateZ() {
	z += 1;
	displayValues();
}
setInterval(updateX, 500);
setInterval(updateY, 1000);
setInterval(updateZ, 2000);