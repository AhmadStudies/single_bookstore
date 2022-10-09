package single_bookstore.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import java.util.logging.LogManager;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.core.Logger;

public class Book {
	Logger logger = LogManager.getLogger();
	
	String bookName;
	
	public String getBook() {
		String methodInfo = "getBook";
		logger.info("Started " + methodInfo);
		
		return "Good Life";
	}
}
