package test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Main {

	public static void main(String[] args) {
		try{
			String raw = "收音机";
			String encode1 = getUtf8Str(raw);
			String raw2 = "收音机 手机";
			String encode2 = getUtf8Str(raw2);
			String raw3 = "收音机 mp3";
			String encode3 = getUtf8Str(raw);
			System.out.println("raw1: " + raw + ";encode1: " + encode1);
			System.out.println("raw2: " + raw2 + ";encode2: " + encode2);
			System.out.println("raw3: " + raw3 + ";encode3: " + encode3);
				
		}catch(Exception ex){
			
		}
	}
	
	private static String getUtf8Str(String raw) throws UnsupportedEncodingException{
		String encode = URLEncoder.encode(raw, "UTF8");
		return encode;
	}
}
