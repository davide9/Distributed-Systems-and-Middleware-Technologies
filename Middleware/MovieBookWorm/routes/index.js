var express = require('express');
var https = require('https');
var http = require('http');
var querystring = require('querystring');
var router = express.Router();


var partialQueryBook = "/books/v1/volumes?maxResults=2&";
var hostBook = 'www.googleapis.com';
var pathBook = '';
var queryTermBook="";
var startIndex = 0;
var htmlBook = '';


function httpGetBook(response){
      var fullRequestQueryBook = partialQueryBook+queryTermBook+"&startIndex="+startIndex;
	  
      console.log('Calling -> ' + fullRequestQueryBook);

	  var headersBook = {
		  'Content-Type': 'application/json'
	  };
	  

	  var optionsBook = {
	    hostname: hostBook,
	    path: fullRequestQueryBook,
	    method: 'GET',
		headers: headersBook
	  };

	  var jsonStringResponseBook = '';

	  var req = https.request(optionsBook, function(res) {
	    console.log("statusCode: ", res.statusCode);
	    console.log("headers: ", res.headers);

	    res.on('data', function(piece) {
	      jsonStringResponseBook += piece;
		  console.log(jsonStringResponseBook);
	    });
		
  	  	res.on('end', function() {
			var content = JSON.parse(jsonStringResponseBook);
			console.log('Found -> ' + content.totalItems);
			htmlBook ='';
			htmlBook += '<h1>Book Search</h1>';
			htmlBook += '<h3>Found -> ' + content.totalItems + '</h3>';
			htmlBook += '<h3>Showing -> ' + content.items.length + '</h3>';
			htmlBook += '<ul>';
			for (var i=0; i<content.items.length; i++) {
				htmlBook += '<li>'+content.items[i].volumeInfo.title+'</li>';
			}
			htmlBook += '</ul>';
			console.log(htmlBook);
			response.send(htmlBook);
  	  	});
		
	  });
	  
	  req.end();
	  
	  req.on('error', function(e) {
	    console.error(e);
	  });
	  
	  
	  
}

var partialQueryMovie = '/api/public/v1.0/movies.json?apikey=';
var hostMovie = 'api.rottentomatoes.com';
var pathMovie = '';
var apiKeyMovie = 'vtbgg3vj4g2cajr672uasjhb';
var startIndex = 0;
var htmlMovie = '';

function httpGetMovie(response) {
  var fullRequestQueryMovie = partialQueryMovie + apiKeyMovie + '&' + queryTermMovie + '&page_limit=2';
  console.log('Calling -> ' + fullRequestQueryMovie);

  var headersMovie = {
	  'Content-Type': 'application/json'
  };
  

  var optionsMovie = {
    host: hostMovie,
    path: fullRequestQueryMovie,
    method: 'GET',
	headers: headersMovie
  };

  var jsonStringResponseMovie = '';

  var req = http.request(optionsMovie, function(res) {
    console.log("statusCode: ", res.statusCode);
    console.log("headers: ", res.headers);

    res.on('data', function(piece) {
      jsonStringResponseMovie += piece;
	  console.log(jsonStringResponseMovie);
    });
	
	  	res.on('end', function() {
		var content = JSON.parse(jsonStringResponseMovie);
		htmlMovie ='';
		htmlMovie += '<h1>Movie Search</h1>';
		htmlMovie += '<h3>Movies found -> ' + content.total + '</h3>';
		htmlMovie += '<h3>Showing -> 2</h3>';
		htmlMovie += '<ul>';
		for (var i=0; i<2; i++) {
			htmlMovie += '<li>'+content.movies[i].title+'</li>';
		}
		htmlMovie += '</ul>';
		response.send(htmlMovie);
	  	});
	
  });
  
  req.end();
  
  req.on('error', function(e) {
    console.error(e);
  });
	
	
};

function httpMovieBookWorm(response, maxPage, queryTermMovie){
	htmlMovie = '';
	var fullRequestQueryMovie = partialQueryMovie + apiKeyMovie + '&' + queryTermMovie + '&page_limit=' + maxPage;
	console.log('Calling -> ' + fullRequestQueryMovie);

	var headersMovie = {
	  'Content-Type': 'application/json'
	};


	var optionsMovie = {
	host: hostMovie,
	path: fullRequestQueryMovie,
	method: 'GET',
	headers: headersMovie
	};

	var jsonStringResponseMovie = '';

	var req = http.request(optionsMovie, function(res) {
		console.log("statusCode: ", res.statusCode);
		console.log("headers: ", res.headers);

		res.on('data', function(piece) {
			jsonStringResponseMovie += piece;
			console.log(jsonStringResponseMovie); 
		});
		var i=0;
		var countI=0;
		res.on('end', function getBook() {
			var contentMovie = JSON.parse(jsonStringResponseMovie);
			
			queryTermBook = querystring.stringify({q:contentMovie.movies[i].title});
			//console.log('prestringify-> ' + contentMovie.movies[i].title);
			console.log('stringify-> '  + queryTermBook);
		
			var fullRequestQueryBook = partialQueryBook+queryTermBook+"&startIndex="+startIndex;
  
			console.log('Calling -> ' + fullRequestQueryBook);

			var headersBook = {
				'Content-Type': 'application/json'
			};


			var optionsBook = {
				hostname: hostBook,
				path: fullRequestQueryBook,
				method: 'GET',
				headers: headersBook
			};

			var jsonStringResponseBook = '';

			var req = https.request(optionsBook, function(res) {
				console.log("statusCode: ", res.statusCode);
				console.log("headers: ", res.headers);

				res.on('data', function(piece) {
					jsonStringResponseBook += piece;
					//console.log(jsonStringResponseBook);
				});

				res.on('end', function() {
					var contentBook = JSON.parse(jsonStringResponseBook);
					console.log('Found -> ' + contentBook.totalItems);
					htmlBook ='';
					htmlBook += '<h1>Movie: ' + contentMovie.movies[i].title + '</h1>';
					htmlBook += '<h3>Found -> ' + contentBook.totalItems + ' books </h3>';
					htmlBook += '<h3>Showing -> ' + contentBook.items.length + '</h3>';
					htmlBook += '<ul>';
					for (var j = 0; j < contentBook.items.length; j++) {
						htmlBook += '<li><a href="' + contentBook.items[j].volumeInfo.infoLink+ '">'+contentBook.items[j].volumeInfo.title+'</a></li>';
					}
					htmlBook += '</ul>';
					console.log(htmlBook);
					htmlMovie += htmlBook;
					countI++;
					if(i++ < contentMovie.movies.length-1)
						getBook();
					else
						response.send(htmlMovie);
				});

			});

			req.end();

			req.on('error', function(e) {
				console.error(e);
			});
			
		});

	});

	req.end();

	req.on('error', function(e) {
	console.error(e);
	});
}

function httpMovieBookWormAPI(response, maxPage, queryTermMovie){
	htmlMovie = '';
	var fullRequestQueryMovie = partialQueryMovie + apiKeyMovie + '&' + queryTermMovie + '&page_limit=' + maxPage;
	console.log('Calling -> ' + fullRequestQueryMovie);
	
	var headersMovie = {
	  'Content-Type': 'application/json'
	};


	var optionsMovie = {
	host: hostMovie,
	path: fullRequestQueryMovie,
	method: 'GET',
	headers: headersMovie
	};

	var jsonStringResponseMovie = '';

	var req = http.request(optionsMovie, function(res) {
		console.log("statusCode: ", res.statusCode);
		console.log("headers: ", res.headers);

		res.on('data', function(piece) {
			jsonStringResponseMovie += piece;
			console.log(jsonStringResponseMovie); 
		});
		var i=0;
		var countI=0;
		var jsonRes = new Array();
		res.on('end', function getBook() {
			var contentMovie = JSON.parse(jsonStringResponseMovie);
			
			queryTermBook = querystring.stringify({q:contentMovie.movies[i].title});
			
			console.log('stringify-> '  + queryTermBook);
		
			var fullRequestQueryBook = partialQueryBook + queryTermBook + "&startIndex=" + startIndex;
  
			console.log('Calling -> ' + fullRequestQueryBook);

			var headersBook = {
				'Content-Type': 'application/json'
			};


			var optionsBook = {
				hostname: hostBook,
				path: fullRequestQueryBook,
				method: 'GET',
				headers: headersBook
			};

			var jsonStringResponseBook = '';

			var req = https.request(optionsBook, function(res) {
				console.log("statusCode: ", res.statusCode);
				console.log("headers: ", res.headers);

				res.on('data', function(piece) {
					jsonStringResponseBook += piece;
				});

				res.on('end', function() {
					var contentBook = JSON.parse(jsonStringResponseBook);
					
					var jsonMovie = new Object();
					jsonMovie.title = contentMovie.movies[i].title;
					jsonMovie.year = contentMovie.movies[i].year;
					jsonMovie.marks = new Object();
					jsonMovie.marks.critics = contentMovie.movies[i].ratings.critics_score;
					jsonMovie.marks.audience = contentMovie.movies[i].ratings.audience_score;
					jsonMovie.poster = contentMovie.movies[i].posters.profile;
					jsonMovie.books = new Array();
					
					console.log('Found -> ' + contentBook.totalItems);
					for (var j = 0; j < contentBook.items.length; j++) {
						jsonMovie.books.push(contentBook.items[j].volumeInfo.infoLink);
					}
					jsonRes.push(jsonMovie);
					countI++;
					if(i++ < contentMovie.movies.length-1)
						getBook();
					else
					{
						response.send(JSON.stringify(jsonRes));
					}
				});

			});

			req.end();

			req.on('error', function(e) {
				console.error(e);
			});
			
		});

	});

	req.end();

	req.on('error', function(e) {
	console.error(e);
	});
}

/* GET home page. */
router.get('/', function(req, res) {
  res.send("<form method='GET' action='/webApp'> \
				Movie <input type='text' name='term'/><br /> \
				Max elements <input type='text' name='np' /><br />\
				<input type='submit'/> \
			</form> ")
});

router.get('/webApp', function(req, res){
	console.log('Receiver request -> ' + req.query.term);
	queryTermMovie = querystring.stringify({q:req.query.term});
	console.log('stringify -> ' + queryTermMovie);
	httpMovieBookWorm(res, req.query.np, queryTermMovie);
})

router.get('/API', function(req, res){
	console.log('Receiver request -> ' + req.query.term);
	queryTermMovie = querystring.stringify({q:req.query.term});
	console.log('stringify -> ' + queryTermMovie);
	httpMovieBookWormAPI(res, req.query.np, queryTermMovie);
})

module.exports = router;
