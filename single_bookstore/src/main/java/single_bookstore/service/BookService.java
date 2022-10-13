package single_bookstore.service;

import java.util.List;

import single_bookstore.model.Book;

public interface BookService {

	
	public int save(Book book);
	
	public int update(Book book);
	
	public Book getBookById(Long id);
	
	public int delete(Long id);
	public List<Book> getAllBooks();
	
	
	
	
	/*
	public Book getBookById(long bookId);
	public boolean addBook(Book book);
	public boolean deleteBookById(long bookId);
	public List<Book> getAllBooks();
	*/
	
}
