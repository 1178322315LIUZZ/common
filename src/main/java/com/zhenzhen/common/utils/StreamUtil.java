package com.zhenzhen.common.utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class StreamUtil {
	public static List<String> read(InputStream InputStream) throws Exception{
		List<String> list=new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(InputStream));
		String line="";
		while((line=reader.readLine())!=null) {
			list.add(line);
		}
		return list;	
	}
	
	public static List<String> read(String filePath) throws Exception{
		FileInputStream inputStream = new FileInputStream(filePath);
		return read(inputStream);
	}
	
	public static List<String> read(File file) throws Exception{
		FileInputStream inputStream = new FileInputStream(file);
		return read(inputStream);
		
	}
}