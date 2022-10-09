package single_bookstore.controller;

import single_bookstore.model.Book;
import single_bookstore.service.BookService;
import single_bookstore.service.BookServiceImpl;

public class BookApi {

	
	public Book getABook(long bookId) {
		BookService bookService = new BookServiceImpl();
		
		Book book = bookService.getBookById(bookId);
		
		
		return book;
	}
}
