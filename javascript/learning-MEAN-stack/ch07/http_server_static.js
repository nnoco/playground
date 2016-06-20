// listing 7.1. http_server_static.js: 기본 정적 파일 웹서버 구현
var fs = require('fs');
var http = require('http');
var url = require('url');
var ROOT_DIR = "html/";
http.createServer(function (req, res) {
	var urlObj = url.parse(req.url, true, false);
	fs.readFile(ROOT_DIR + urlObj.pathname, function (err, data) {
		if (err) {
			res.writeHead(404);
			res.end(JSON.stringify(err));
			return;
		}
		res.writeHead(200);
		res.end(data);
	});
}).listen(8080);
