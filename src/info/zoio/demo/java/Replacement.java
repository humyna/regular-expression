package info.zoio.demo.java;

import java.util.regex.Pattern;

public class Replacement {
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("[/]");
		String[] strs = pattern.split("Kevin has seen 《 LEON 》 seveal times,because it is a good film."
				 +"/ 凯文已经看过《这个杀手不太冷》几次了，因为它是一部"
				 +"好电影。/ 名词 : 凯文。",2);
		
		for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}
		
	}
}
