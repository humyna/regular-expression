package info.zoio.demo.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 使用正則表達式校驗email
 * 
 * @author feih
 */
public class CheckEmailByRegexTest {

	public static void main(String[] args) {
		String input = args[0];
		Pattern pattern = Pattern.compile("^\\.|^\\@");
		Matcher matcher = pattern.matcher(input);
		if (matcher.find()) {
			System.err.println("EMAIL地址不能以'.'或'@'作为起始字符");
		}
		
		// 检测是否以"www."为起始
		pattern = Pattern.compile("^www\\.");
		matcher = pattern.matcher(input);
		if (matcher.find()) {
			System.out.println("EMAIL地址不能以'www.'起始");
		}
		
		// 检测是否包含非法字符
		pattern = Pattern.compile("[^A-Za-z0-9\\.\\@_\\-~#]+");
		matcher = pattern.matcher(input);
		StringBuffer sb = new StringBuffer();
		boolean result = matcher.find();
		boolean deletedIllegalChars = false;
		while(result){
			deletedIllegalChars = true;
			// 如果里面包含非法字符如冒号双引号等，那么就把他们消去，加到 SB里面
			matcher.appendReplacement(sb, "");
			result = matcher.find();
		}
		matcher.appendTail(sb);
		if (deletedIllegalChars) { 
	          System.out.println("输入的 EMAIL地址里包含有冒号、逗号等非法字符，请修改"); 
	          System.out.println("您现在的输入为 : "+args[0]); 
	          System.out.println("修改后合法的地址应类似 : "+sb.toString()); 
	     } 
	}

}
