// listing 6.1. file_write.js: 파일에 JSON 문자열 쓰기
var fs = require('fs');
var config = {
	maxFiles: 20,
	maxConnections: 15,
	rootPath: "/webroot"
};
var configTxt = JSON.stringify(config);
var options = { encoding: 'utf8', flag:'w'};
fs.writeFile('./data/config.txt', configTxt, options, function(err) {
	if (err) {
		console.log("Config Write Failed.");
		console.log(err);
	} else {
		console.log("Config Saved.");
	}
});