// listing 6.3. file_write_async.js: 파일에 비동기 쓰기
var fs = require('fs');
var fruitBowl = ['apple', 'orange', 'banana', 'grapes'];
function writeFruit(fd) {
	if (fruitBowl.length) {
		var fruit = fruitBowl.pop() + " ";
		fs.write(fd, fruit, null, null, function(err, bytes) {
			if (err) {
				console.log("File Write Failed.");
			} else {
				console.log("Wrote: %s %dbytes", fruit, bytes);
				writeFruit(fd);
			}
		});
	} else {
		fs.close(fd);
	}
}

fs.open('./data/fruit.txt', 'w', function(err, fd) {
	writeFruit(fd);
});