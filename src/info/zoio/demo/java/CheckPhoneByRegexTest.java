package info.zoio.demo.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CheckPhoneByRegexTest {
	public static void main(String[] args) {
		BufferedReader in;
		//1.匹配如下格式的电话号码 (nnn)nnn-nnnn、(nnn) nnn-nnnn、nnnnnn-nnnn、nnnnnnnnnn、(nnn)nnnnnnn等 
//		Pattern pattern = Pattern.compile("(\\(\\d{3}\\)|\\d{3})\\s?\\d{3}(-|)?\\d{4}");//注意是\而不是/
		//2.检查文本文件中是否有重复的单词，大小写不敏感
		Pattern pattern = Pattern.compile("\\b(\\w+)\\s+\\1\\b",Pattern.CASE_INSENSITIVE);
		String s;
		try {
//			in = new BufferedReader(new FileReader("phone"));
			in = new BufferedReader(new FileReader("checkword"));
			while((s = in.readLine()) != null){
				Matcher matcher = pattern.matcher(s);
				if(matcher.find()){
					System.out.println(matcher.group());
				}else{
					System.out.println("no matcher!");
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

