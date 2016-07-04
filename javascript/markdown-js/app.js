var markdown = require('markdown').markdown;

md_content = "Hello.\n\n* This is markdown.\n* It is fun\n* Love it or leave it."
html_content = markdown.toHTML( md_content );

console.log(html_content);
