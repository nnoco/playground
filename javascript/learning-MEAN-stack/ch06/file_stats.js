var fs = require('fs');
fs.stat('file_stats.js', function(err, stats) {
	if (!err) {
		console.log('stats: ' + JSON.stringify(stats, null, ' '));
	}
});