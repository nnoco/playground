## Application 객체
- app.set(name, value) : 구성에서 사용할 환경변수 설정
- app.get(name);
- app.engine(ext, callback): 특정 파일 타입을 출력하기 위해 필요한 템플릿 엔진을 정의. 예를 들어 HTML 파일을 템플릿으로 사용하게 EJS 템플릿 엔진에 알리려면 다음처럼 지정한다. `app.engine('html', require('ejs').renderFile)`
- app.locals: 애플리케이션 수준의 변수를 출력하기 위해 모든 템플릿에 전송
- app.use([path], callback)
- app.VERB(path, [callback...], callback) 선언된 HTTP 동사가 특정 경로와 연결된 HTTP 요청에 응답하기 위한 미들웨어 함수를 하나 이상 정의한다. 예를 들어 GET  동사를 사용하는 요청에 응답하기를 원할 때, app.get() 메서드를 사용해 미들웨어를 할당할 수 있다. POST 요청에 대해서는 `app.post()`를 사용하며 나머지도 유사.
- app.route(path).VERB([callback...], callback): 여러 HTTP  동사가 특정 경로와 연결된 HTTP 요청에 응답하기 위한 미들웨어 함수를 하나 이상 정의한다. 예를 들어 GET과 POST 동사를 사용하는 요청에 응답하기를 원할 때 `app.route(path).get(callback).post(callback)`을 사용해 적절한 미들웨어 함수를 할당할 수 있다.
- app.param([name], callback): 특정 라윙 매개변수를 포함한 경로로 들어오는 요청에 특정 기능을 붙인다. 예를 들어 `app.param('userId', callback)`을 사용해 userId 매개 변수를 포함한 요청에 특정 논리를 붙일 수 있다.
  
## 요청 객체
- req.query
- req.params
- req.body: bodyParser() 미들웨어에 포함
- req.param(name)
- req.path, req.host, req.ip
- req.cookies: cookieParser() 미들웨어와 함께 사용
  
## 응답 객체
- res.status(code)
- res.set(field, [value]): 헤더 설정
- res.cookie(name, value, [options]): options 인수는 maxAge 속성과 같은 일반적인 쿠키 구성을 정의하는 객체를 전달하기 위해 사용
- res.redirect([status], url)
- res.send([body|status], [body])
- res.json([status|body], [body])
- res.render(view, [locals], callback)
  
## 외부 미들웨어
- morgan : HTTP 요청 로거 미들웨어
- body-parser: 요청 내용을 해석하는 미들웨어, 다양한 요청 타입 지원
- method-override: 클라이언트가 지원하지 않는 곳에서 PUT이나 DELETE와 같은 HTTP 메서드를 적절히 제공하는 미들웨어
- compression: gzip/deflate를 사용해 응답 데이터를 압축하는 미들웨어
- express.static: 정적 파일을 서비스하는 미들웨어
- cookie-parser: req.cookies 객체를 채우기 위한 쿠키 해석용 미들웨어
- session: 영속적인 세션을 지원하기 위해 사용하는 미들웨어
