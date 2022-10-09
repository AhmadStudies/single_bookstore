package single_bookstore.service;

import java.util.List;

import single_bookstore.model.Book;

public interface BookService {

	public Book getBookById(long bookId);
	public boolean addBook(Book book);
	public boolean deleteBookById(long bookId);
	public List<Book> getAllBooks();
	
}
