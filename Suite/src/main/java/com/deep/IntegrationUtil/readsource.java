package com.deep.IntegrationUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;


public class readsource {
	private final Properties configProp = new Properties();

	private readsource() {
		// Private constructor to restrict new instances
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("IntegrationUtil");
		System.out.println("Read all properties from file");
		try {
			configProp.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static class Holder
	   {
	      private static final readsource INSTANCE = new readsource();
	   }
	 
	   public static readsource getInstance()
	   {
	      return Holder.INSTANCE;
	   }
	    
	   public String getProperty(String key){
	      return configProp.getProperty(key);
	   }
	    
	   public Set<String> getAllPropertyNames(){
	      return configProp.stringPropertyNames();
	   }
	    
	   public boolean containsKey(String key){
	      return configProp.containsKey(key);
	   }
	}

