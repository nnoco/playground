// listing 6.6. file_read_sync.js: 동기적 파일 읽기
var fs = require('fs');
var fd = fs.openSync('./data/veggie.txt', 'r');
var veggies = "";
do {
	var buf = new Buffer(5);
	buf.fill();
	var bytes = fs.readSync(fd, buf, null, 5);
	console.log("read %dbytes", bytes);
	veggies += buf.toString();
} while( bytes > 0 );
fs.closeSync(fd);
console.log("Veggies: " + veggies);