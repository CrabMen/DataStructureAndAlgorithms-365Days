package com.sequence;

public class BruteForce02 {

	public static int indexOf(String text, String pattern) {
		if (text == null || pattern == null)
			return -1;
		if (text.length() == 0 || pattern.length() == 0)
			return -1;
		if (pattern.length() > text.length())
			return -1;

		char[] textChars = text.toCharArray();
		char[] patternChars = pattern.toCharArray();
		int tlen = textChars.length;
		int plen = patternChars.length;
		// 使用ti表达对比字符串的起始位置 ,则ti + pi代表当前对比的index
		int tiMax = tlen - plen;
		for (int ti = 0; ti <= tiMax; ti++) {
			int pi = 0;//便于for循环以后使用
			for (; pi < plen; pi++) {
				if (textChars[ti + pi] != patternChars[pi])
					break;
			}
			if (pi == plen)
				return ti;
		}
		return -1;
	}
}
