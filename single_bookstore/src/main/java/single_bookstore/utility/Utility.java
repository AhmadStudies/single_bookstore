package single_bookstore.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utility {

	protected static String MYSQL_USER = "";
	protected static String MYSQL_PASSWORD = "";
	protected static String MYSQL_URL = "";
	
	static Logger logger = LogManager.getLogger();
	
	public static void readLocalVariables() {
		
		
		try {
			MYSQL_USER = Utility.readProperties("MysqlUser");
			MYSQL_PASSWORD = Utility.readProperties("MysqlPassword");
			MYSQL_URL = Utility.readProperties("MysqlUrl");
		}catch(Exception ex) {
			logger.error("errore while reading local variables");
		}
		
	}
	
	public static String readProperties(String propertyName) {
		String readProperty = System.getProperty(propertyName);
		if(readProperty == null) {
			System.out.println("the property " + propertyName + " is a value null");
			return "";
		}
		return readProperty;
	}
	
	public static void setLocalVariable() throws IOException {
		HashMap<String, String> locVar = new HashMap<String, String>();
		
		String fileName = "./allConfigs/config.properties";
		
		Properties allProperties = new Properties();
		InputStream streamFilepro = null;
		
		try {
			streamFilepro = new FileInputStream(fileName);
			
			allProperties.load(streamFilepro);
			for(String key: allProperties.stringPropertyNames()) {
				locVar.put(key, allProperties.getProperty(key));
			}
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(streamFilepro != null) {
				streamFilepro.close();
			}
		}
		
		
		System.setProperty("MysqlUser", locVar.get("MysqlUser"));
		System.setProperty("MysqlPassword", locVar.get("MysqlPassword"));
		System.setProperty("MysqlUrl", locVar.get("MysqlUrl"));
	}
}
