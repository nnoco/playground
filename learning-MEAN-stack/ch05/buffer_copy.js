var alphabet = new Buffer('abcdefghijklmnopqrstuvwxyz');
console.log(alphabet.toString());
// 전체 버퍼를 복사한다.
var blank = new Buffer(alphabet.length);
blank.fill();
console.log("Blank: " + blank.toString());
alphabet.copy(blank);
console.log("Blank: " + blank.toString());
// 버퍼의 일부분을 복사한다.
var dashes = new Buffer(26);
dashes.fill('-');
console.log('Dashes: ' + dashes.toString());
alphabet.copy(dashes, 10, 10, 15);
console.log('Dashes: ' + dashes.toString());
// 버퍼의 특정 부분을 기준으로 삼아 복사한다.
var dots = new Buffer('--------------------------');
dots.fill('.');
console.log('dots: ' + dots.toString());
for (var i=0; i < dots.length; i++) {
	if (i % 2) { dots[i] = alphabet[i]; }
}
console.log('Dots: ' + dots.toString());