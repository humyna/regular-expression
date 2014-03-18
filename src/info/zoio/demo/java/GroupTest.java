package info.zoio.demo.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Matcher的組方法
 * group()/group(int group)/groupCount()
 * 
 * @author feih
 *
 */
public class GroupTest {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("(ca)(t)");
		Matcher m = p.matcher("one cat,two cats in the yard");
		boolean result = m.find();//刪除程序會報錯：Exception in thread "main" java.lang.IllegalStateException: No match found
		System.out.println("该次查找获得匹配组的数量为：" + m.groupCount());
		for (int i = 1; i <= m.groupCount(); i++) {
			System.out.println("第" + i + "组的子串内容为： " + m.group(i));
		}
	}
}
