package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	
	String path = "config.properties";
	Properties pro;
	
  public ReadConfig() throws Exception
   {
	     pro = new Properties();   
	     FileInputStream fis= new FileInputStream(path);
	     pro.load(fis);	
	}
  
  public String getBrowser()
  {
	  String value = pro.getProperty("browser");
	  if(value!=null)
	  return value;
	  else
		  throw new RuntimeException("url not specified in config file.");
  }
}
