// 익스프레스 애플리케이션 구성(설정)
module.exports = require('./env/' + process.env.NODE_ENV + '.js');