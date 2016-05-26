// listing 6.8 file_read_stream.js: 파일에서 스트리밍 읽기 가능한 Readable 스트림 구현
var fs = require('fs');
var options = { encoding: 'utf8', flag: 'r' };
var fileReadStream = fs.createReadStream('./data/grains.txt', options);
fileReadStream.on('data', function(chunk) {
	console.log('Grains: %s', chunk);
	console.log('Read %d bytes of data.', chunk.length);
});
fileReadStream.on('close', function() {
	console.log("File Closed.");
});