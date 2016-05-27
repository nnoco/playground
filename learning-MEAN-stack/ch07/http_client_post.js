// listing 7.6. http_client_post.js: POST 방식으로 JSON 데이터를 서버에 보내고 JSON 응답을 처리하는 기본 HTTP 클라이언트
var http = require('http');
var options = {
	host: '127.0.0.1',
	path: '/',
	port: '8080',
	method: 'POST'
};
function readJSONResponse(response) {
	var responseData = '';
	response.on('data', function (chunk) {
		responseData += chunk;
	});
	response.on('end', function() {
		var dataObj = JSON.parse(responseData);
		console.log("Raw response: " + responseData);
		console.log("Message: " + dataObj.message);
		console.log("Question: " + dataObj.question);
	});
}
var req = http.request(options, readJSONResponse);
req.write('{"name":"Bilbo", "occupation": "Burglar"}');
req.end();