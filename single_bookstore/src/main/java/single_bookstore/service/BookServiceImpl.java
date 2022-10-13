package single_bookstore.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;  
import org.springframework.jdbc.core.JdbcTemplate;   
import org.springframework.jdbc.core.RowMapper;

import single_bookstore.model.Book;

public class BookServiceImpl implements BookService{
	
	
	private JdbcTemplate jdbcTemplate;
	
	public BookServiceImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	RowMapper<Book> rowMapper = (rs, rowNum) -> {
		Book book = new Book();
		book.setBookId(rs.getInt("book_id"));
		book.setTitle(rs.getString("title"));
		book.setAuthor(rs.getString("author"));
		book.setTotalPages(rs.getInt("total_pages"));
		book.setPrice(rs.getFloat("price"));
		book.setPublishDate(rs.getDate("published_date"));
		return book;
	};

	@Override
	public int save(Book book) {
		String sql = "INSERT INTO book (title, author, total_pages, price, published_date FROM student) VALUES (?,?,?,?,?)";
		
		return jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getTotalPages(), book.getPrice(), book.getPublishDate());
	}

	@Override
	public int update(Book book) {
		String sql = "UPDATE book SET title=?, author=?, total_pages=?,price=?, published_date=? WHERE book_id = ? ";
		
		return jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getTotalPages(), book.getPrice(), book.getPublishDate());
	}

	@SuppressWarnings("deprecation")
	@Override
	public Book getBookById(Long id) {
	
		String sql = "SELECT book_id, title, author, total_pages,price, published_date WHERE book_id = ? ";
		Book book = null;
		try {
			book = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
		}catch (DataAccessException ex) {
			// Here Must be a logger
			System.out.println("Book not found " + id);
		}
		
		return book;
	}

	@Override
	public int delete(Long id) {
		
		return jdbcTemplate.update("DELETE FROM book WHERE book_id = ?",id);
	}

	
	@Override
	public List<Book> getAllBooks() {
	
		String sql = "SELECT book_id, title, author,total_pages, price, published_date FROM books";
	    
	      return jdbcTemplate.query(sql, rowMapper);

	}


}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * 
	 * 

	@Override
	public Book getBookById(long bookId) {
	
		return null;
	}

	@Override
	public boolean addBook(Book book) {
		
		return false;
	}




	@Override
	public boolean deleteBookById(long bookId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	*/
	

}
