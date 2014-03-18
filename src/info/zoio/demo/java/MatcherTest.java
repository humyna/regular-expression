package info.zoio.demo.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * matches()/lookingAt ()/find()： 
 * 一个 Matcher 对象是由一个 Pattern 对象调用其 matcher() 方法而生成的，一旦该 Matcher 对象生成 , 它就可以进行三种不同的匹配查找操作：
 * matches() 方法尝试对整个目标字符展开匹配检测，也就是只有整个目标字符串完全匹配时才返回真值。
 * lookingAt () 方法将检测目标字符串是否以匹配的子串起始。
 * find() 方法尝试在目标字符串里查找下一个匹配子串。
 * 以上三个方法都将返回一个布尔值来表明成功与否。
 * 
 * Matcher 类同时提供了四个将匹配子串替换成指定字符串的方法：
 * replaceAll()
 * replaceFirst()
 * appendReplacement()
 * appendTail()
 * 
 * replaceAll() 与 replaceFirst() 的用法都比较简单。我们主要重点了解一下 appendReplacement() 和 appendTail() 方法。
 * appendReplacement(StringBuffer sb, String replacement) 将当前匹配子串替换为指定字符串，
 * 并且将替换后的子串以及其之前到上次匹配子串之后的字符串段添加到一个 StringBuffer 对象里，
 * 而 appendTail(StringBuffer sb) 方法则将最后一次匹配工作后剩余的字符串添加到一个 StringBuffer 对象里。
 *
 * 例如，有字符串 fatcatfatcatfat, 假设既有正则表达式模式为"cat"，
 * 第一次匹配后调用 appendReplacement(sb,"dog"), 那么这时 StringBuffer sb 的内容为 fatdog，也就是 fatcat 中的 cat 被替换为 dog 并且与匹配子串前的内容加到 sb里，
 * 而第二次匹配后调用 appendReplacement(sb,"dog")，那么 sb 的内容就变为 fatdogfatdog，
 * 如果最后再调用一次 appendTail（sb）, 那么 sb 最终的内容将是 fatdogfatdogfat。
 * 
 * @author feih
 *
 */
public class MatcherTest {
	public static void main(String[] args) {
		//将把句子里的"Kelvin"改为"Kevin"
		replaceAll("Kelvin", "Kevin", "Kelvin Li and Kelvin Chan are both working in " +
			"Kelvin Chen's KelvinSoftShop company");
	}

	/**
	 * 字符创替换方法
	 * 
	 * @param str 替换子串
	 * @param des 被替换子串
	 * @param strs 目标字符串
	 */
	private static void replaceAll(String str,String des,String strs){
		Pattern pattern = Pattern.compile(str);
		Matcher matcher = pattern.matcher(strs);
		StringBuffer sb = new StringBuffer();
		int i = 0;
		boolean result =  matcher.find();
		while(result){
			i++;
			matcher.appendReplacement(sb, des);
			System.out.println("第" + i + "次匹配后sb的内容是：" + sb);
			result = matcher.find();
		}
		
		matcher.appendTail(sb);
		System.out.println("调用 m.appendTail(sb) 后 sb 的最终内容是 :"+ 
				sb.toString());
	}
}


