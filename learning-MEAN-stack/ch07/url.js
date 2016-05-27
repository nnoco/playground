var url = require('url');
var urlStr = 'http://user:pass@host.com:80/resourse/path?query=string#hash';
var urlObj = url.parse(urlStr, true, false);
var urlString = url.format(urlObj);

console.log(urlStr);
console.log(urlObj);
console.log(urlString);
console.log(url.parse(urlStr));

console.log();

var originalUrl = 'http://user:pass@host.com:80/resource/path?query=string#hash';
var newResource = '/another/path?querynew';
console.log(url.resolve(originalUrl, newResource));

var querystring = require('querystring');

var params = querystring.parse("name=Brad&color=red&color=blue");
console.log(params);
console.log(querystring.stringify(params));