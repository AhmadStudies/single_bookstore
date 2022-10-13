package single_bookstore.model;

import java.sql.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import java.util.logging.LogManager;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.core.Logger;

public class Book {
	
	private Integer bookId;
	private String title;
	private String author;
	private int totalPages;
	private float price;
	private Date publishDate;
	public Book(Integer bookId, String title, String author, int totalPages, float price, Date publishDate) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.totalPages = totalPages;
		this.price = price;
		this.publishDate = publishDate;
	}
	
	public Book() {
		
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
	
	
	
	
}
