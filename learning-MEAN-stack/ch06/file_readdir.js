// listing 6.10 file_readdir.js: 콜백 체인을 구성해 디렉토리 구조를 탐색하고 항목을 출력
var fs = require('fs');
var Path = require('path');
function WalkDirs(dirPath) {
	console.log(dirPath);
	fs.readdir(dirPath, function(err, entries) {
		for (var idx in entries) {
			var fullPath = Path.join(dirPath, entries[idx]);
			(function(fullPath) {
				fs.stat(fullPath, function (err, stats) {
					if (stats && stats.isFile()) {
						console.log(fullPath);
					} else if (stats && stats.isDirectory()) {
						WalkDirs(fullPath);
					}
				});
			})(fullPath);
		}
	});
}
WalkDirs(".");