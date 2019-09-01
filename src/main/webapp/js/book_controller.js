var myController = myApp.controller("myController", ['BookService', '$scope', function(BookService, $scope){
	
	self = this;
	self.submit = submit;
	self.remove = remove;
	self.edit = edit;
	
	self.book = {id: null, name : '', author : '', summary: '', year : null, page : null, isbn : ''};
	self.books = [];
	
	listBooks();
	
	function submit() {
		if(self.book.id == null) {
			BookService.save(self.book)
				.then(function(response) { listBooks(); reset(); },
						function(response) {});
		} else {
			BookService.update(self.book)
			.then(function(response) { listBooks(); reset(); },
					function(response) {});
		}
	}
	
	function reset() {
		self.book = {id: null, name : '', author : '', summary: '', year : null, page : null, isbn : ''};
        $scope.myForm.$setPristine(); //reset Form
	}
	
	
	function listBooks() {
		BookService.getBooks()
		.then(function(data) { self.books = data },
				function(response) {});
	}
	
	function remove(id) {
		BookService.remove(id)
		.then(function(data) { listBooks(); },
				function(response) {});
	}
	
	function edit(id) {
		BookService.getBook(id)
		.then(function(data) { self.book = data; },
				function(response) {});
	}
	
}]);