package generic_Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class File_Utility {

	public String getDataFromProperty(String key) throws IOException {
		FileInputStream fis=new FileInputStream(IConsatnts_Utility.propertyfileConstant);
		Properties p=new Properties();
		p.load(fis);
		String Value=p.getProperty(key);
		
		return Value;
		
		
	}
}
