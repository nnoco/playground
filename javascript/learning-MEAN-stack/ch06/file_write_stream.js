// listing 6.4. file_write_stream.js: 스트리밍 방식으로 파일 쓰기 구현
var fs = require('fs');
var grains = ['wheat', 'rice', 'oats'];
var options = { encoding: 'utf8', flag: 'w'};
var fileWriteStream = fs.createWriteStream("./data/grains.txt", options);
fileWriteStream.on("close", function() {
	console.log("File Closed");
});
while (grains.length) {
	var data = grains.pop() + " ";
	fileWriteStream.write(data);
	console.log("Wrote: %s", data);
}
fileWriteStream.end();