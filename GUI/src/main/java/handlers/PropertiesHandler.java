package handlers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHandler {
	private static volatile PropertiesHandler INSTANCE = null;
	private Properties properties = null;
	private InputStream inputStream = null;
	
	private PropertiesHandler() throws IOException {
		properties = new Properties();
		String propFileName = "gui.properties";
		try {
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			if (inputStream != null) {
				properties.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			inputStream.close();
		}
	}
	
	public static PropertiesHandler getInstance() throws IOException {
		if (INSTANCE == null) {
            synchronized (PropertiesHandler.class) {
                if (INSTANCE == null) {
                	INSTANCE = new PropertiesHandler();
                }
            }
        }
        return INSTANCE;
	}
	
	 public String getValue(String key) {
	        return properties.getProperty(key);
	    }

}
