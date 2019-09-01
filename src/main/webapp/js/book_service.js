var myApp = angular.module("myApp", []);
myApp.factory('BookService', ['$http', '$q', function($http, $q) {
	
	var factory = {
		save : save,
		getBooks : getBooks,
		remove : remove,
		getBook : getBook,
		update : update
	}
	return factory;
	
	function remove(id) {
		var deferred = $q.defer();
		$http.delete('/books/' + id)
			.then(function(response) { deferred.resolve(response.data)},
					function(response) {deferred.reject(response)});
		return deferred.promise;
	}
	
	function getBook(id) {
		var deferred = $q.defer();
		$http.get('/books/' + id)
			.then(function(response) { deferred.resolve(response.data)},
					function(response) {deferred.reject(response)});
		return deferred.promise;
	}
	
	function save(book) {
		var deferred = $q.defer();
		$http.post('/books', book)
			.then(function(response) { deferred.resolve(response.data)},
					function(response) {deferred.reject(response)});
		return deferred.promise;
	}
	
	function update(book) {
		var deferred = $q.defer();
		$http.put('/books/' + book.id, book)
			.then(function(response) { deferred.resolve(response.data)},
					function(response) {deferred.reject(response)});
		return deferred.promise;
	}
	
	function getBooks() {
		var deferred = $q.defer();
		$http.get('/books')
			.then(function(response) { deferred.resolve(response.data)},
					function(response) {deferred.reject(response)});
		return deferred.promise;
	}
	
}]);