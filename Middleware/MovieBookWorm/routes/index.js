var express = require('express');
var https = require('https');
var http = require('http');
var querystring = require('querystring');
var router = express.Router();


var partialQueryBook = "/books/v1/volumes?maxResults=2&";
var hostBook = 'www.googleapis.com';
var startIndex = 0;

var partialQueryMovie = '/api/public/v1.0/movies.json?apikey=';
var hostMovie = 'api.rottentomatoes.com';
var apiKeyMovie = 'vtbgg3vj4g2cajr672uasjhb';
var startIndex = 0;

var myHost = '127.0.0.1';

function httpMovieBookWormAPI(response, maxPage, queryTermMovie){
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
			//console.log(jsonStringResponseMovie); 
		});
		var i=0;
		var countI=0;
		var jsonRes = new Array();
		res.on('end', function getBook() {
			var contentMovie = JSON.parse(jsonStringResponseMovie);
			if(contentMovie.movies.length == 0) { response.json("{}"); return;}
			var queryTermBook = querystring.stringify({q:contentMovie.movies[i].title});
			
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
					
					var headersDirector = {
					  'Content-Type': 'application/json'
					};
					
					var optionsDirector = {
						host: hostMovie,
						path: contentMovie.movies[i].links.self.substr(29) + '?apikey=' + apiKeyMovie,
						method: 'GET',
						headers: headersDirector
					};
					
					var jsonStringResponseDirector = '';
					
					console.log('Calling -> ' + optionsDirector.path);
					
					var req = http.request(optionsDirector, function(res){
						console.log("statusCode: ", res.statusCode);
						console.log("headers: ", res.headers);
						
						res.on('data', function(piece){
							jsonStringResponseDirector += piece;
						});
						
						res.on('end', function(){
							var contentDirector = JSON.parse(jsonStringResponseDirector);
							
							var jsonMovie = new Object();
							jsonMovie.title = contentMovie.movies[i].title;
							jsonMovie.year = contentMovie.movies[i].year;
							jsonMovie.marks = new Object();
							jsonMovie.marks.critics = contentMovie.movies[i].ratings.critics_score;
							jsonMovie.marks.audience = contentMovie.movies[i].ratings.audience_score;
							jsonMovie.directors = new Array();
							console.log('Baggio culo: ' + contentDirector.abridged_directors);
							if(typeof(contentDirector.abridged_directors) != "undefined"){
								for(var d = 0; d < contentDirector.abridged_directors.length; d++){
									var director = new Object();
									director.name = contentDirector.abridged_directors[d].name;
									jsonMovie.directors.push(director);
								}
							}
							jsonMovie.poster = contentMovie.movies[i].posters.profile;
							jsonMovie.books = new Array();
							
							console.log('Found -> ' + contentBook.totalItems);
							for (var j = 0; j < contentBook.items.length; j++) {
								var jsonBook = new Object();
								jsonBook.link = contentBook.items[j].volumeInfo.infoLink;
								jsonBook.title = contentBook.items[j].volumeInfo.title;
								jsonMovie.books.push(jsonBook);
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
					
					req.on('error', function(e){
						console.error(e);
					})
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

function httpMovieBookWormApp(response, maxPage, queryTermMovie){
	var fullRequestQueryMovie = '/API?' + queryTermMovie + '&' + 'np=' + maxPage;
	
	console.log('Calling -> ' + fullRequestQueryMovie);
	
	var headersMovie = {
	  'Content-Type': 'application/json'
	};


	var optionsMovie = {
	host: myHost,
	port: 3000,
	path: fullRequestQueryMovie,
	method: 'GET',
	headers: headersMovie
	};

	var jsonStringResponse = '';

	var req = http.request(optionsMovie, function(res) {
		console.log("statusCode: ", res.statusCode);
		console.log("headers: ", res.headers);
		
		res.on('data', function(piece){
			jsonStringResponse += piece;
		});
		
		res.on('end', function(){
			var webAppData = JSON.parse(jsonStringResponse);
			if(typeof(webAppData) == "undefined" || jsonStringResponse == '{}'){
				response.send('No results');
				return;
			}
			
			var httpResponse = '<h1>Movies</h1><br /><ul>';
			
			for(var i=0; i<webAppData.length; i++){
				httpResponse += '<li>';
				
				httpResponse += '<h2>' + webAppData[i].title + '</h2><br />';
				httpResponse += '<a href="' + webAppData[i].poster +'"><img src="' + webAppData[i].poster + '" /></a><br />';
				httpResponse += '<b>Year: </b>' + webAppData[i].year + '<br />';
				httpResponse += '<b>Score: </b> critics ' + webAppData[i].marks.critics + ' audience ' + webAppData[i].marks.audience + '<br />';
				httpResponse += '<b>Directors: </b><ul>';
					for(var j=0; j<webAppData[i].directors.length; j++){
						httpResponse += '<li>' + webAppData[i].directors[j].name + '</li>';
					}
				httpResponse += '</ul><br />';
				httpResponse += '<b>Related Books: </b><ul>';
					for(var j=0; j<webAppData[i].books.length; j++){
						httpResponse += '<li><a href="' + webAppData[i].books[j].link + '" >' + webAppData[i].books[j].title + '</a></li>';
					}
				httpResponse += '</ul><br />';
				
				httpResponse += '</li>';
			}
			
			httpResponse += '</ul>';
			
			response.send(httpResponse);
		});
	});
	
	req.end();
	
	req.on('error', function(e){
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

router.get('/API', function(req, res){
	console.log('Receiver request -> ' + req.query.term);
	var queryTermMovie = querystring.stringify({q:req.query.term});
	console.log('stringify -> ' + queryTermMovie);
	httpMovieBookWormAPI(res, req.query.np, queryTermMovie);
})

router.get('/webApp', function(req, res){
	console.log('Receiver request -> ' + req.query.term);
	var queryTermMovie = querystring.stringify({term:req.query.term});
	console.log('stringify ->' + queryTermMovie);
	httpMovieBookWormApp(res, req.query.np, queryTermMovie);
})

module.exports = router;
