## NPM을 사용한 패키지 설치
```
$ npm install <Package 이름>
$ npm install -g <패키지 이름>
$ npm install express
$ npm install <패키지이름>@<패키지 버전>
$ npm uninstall <패키지 이름>
$ npm uninstall -g <패키지 이름>
$ npm update <패키지 이름>
$ npm update -g <패키지 이름>
```
  
## package.json
```
{
	"name" : "...",
	"version" : "...",
	"dependencies" : {
		"dep-name" : "version",
		"dep-name" : "version",
	}
}
```
  
package.json 파일 생성 `$ npm init`  
  
package.json 의존성 설치 : `$ npm install`  
  
package.json 갱신 : `$ npm install express --save` - 설치하면서 갱신