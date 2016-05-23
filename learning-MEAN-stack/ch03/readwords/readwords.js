var censor = require("censorify-nnoco");
console.log(censor.getCensoredWords());
console.log(censor.censor("Some very sad, bad and mand text."));
censor.addCensoredWord("gloomy");
console.log(censor.getCensoredWords());
console.log(censor.censor("A very gloomy day."));