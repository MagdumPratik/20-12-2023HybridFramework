package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	Properties pr;
	
	public ConfigReader()
	{
		String filePath=".//PropertyFile//Config.properties";
		try
		{
			FileInputStream fis=new FileInputStream(filePath);
			pr=new Properties();
			pr.load(fis);
			
		}
		catch(Exception e)
		{
			System.out.println("FIle not found");
		}
	}
	
	public String getApplicationUrl()
	{
		return pr.getProperty("url");
	}
	
	public String getUsername()
	{
		return pr.getProperty("username");
	}
	
	public String getPassword()
	{
		return pr.getProperty("password");
	}
	
}
