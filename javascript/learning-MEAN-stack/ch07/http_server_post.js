// listing 7.5. http_server_post.js: HTTP POST 요청을 처리하는 기본 HTTP 서버 구현
var http = require('http');
http.createServer(function(req, res) {
	var jsonData = "";
	req.on('data', function (chunk) {
		jsonData += chunk;
	});
	req.on('end', function() {
		var reqObj = JSON.parse(jsonData);
		var resObj = {
			message: "Hello " + reqObj.name,
			question: "Are you a good " + reqObj.occupation + "?"
		};
		res.writeHead(200);
		res.end(JSON.stringify(resObj));
	});
	
}).listen(8080);