package com.sequence;

public class KMP {

	public static int indexOf(String text, String pattern) {
		if (text == null || pattern == null)
			return -1;
		if (text.length() == 0 || pattern.length() == 0)
			return -1;
		char[] textChars = text.toCharArray();
		char[] patternChars = pattern.toCharArray();

		int tlen = textChars.length;
		int plen = patternChars.length;

		if (tlen < plen)
			return -1;
		// next表
		int[] next = next1(pattern);

		int pi = 0, ti = 0, lenDelta = tlen - plen;
		while (pi < plen && ti - pi <= lenDelta) {
			// pi = -1 时,pi++ 归零 ,ti往后移动一位
			if (pi < 0 || textChars[ti] == patternChars[pi]) {
				ti++;
				pi++;
			} else {
				pi = next[pi];
			}
		}
		return (pi == plen) ? (ti - pi) : -1;
	}

	/**
	 * next 数组各值的含义：
	 * 
	 * 代表当前字符之前的字符串中，相同真前缀后缀的最大长度。
	 * 
	 * 相当于当前字符串的真前缀后缀的“最大长度值” 整体向右移动一位，然后初始值赋为-1。
	 * 
	 */

	private static int[] next1(String pattern) {
		char[] chars = pattern.toCharArray();
		int[] next = new int[chars.length];

		next[0] = -1;
		int i = 0;
		int n = -1;

		// chars[n]表示前缀，chars[i]表示后缀
		int iMax = chars.length - 1;

		while (i < iMax) {
			if (n < 0 || chars[i] == chars[n]) {
				++i;
				++n;
				if (chars[i] == chars[n])
					next[i] = next[n];
				else
					next[i] = n;
			} else {
				n = next[n];
			}
		}
		return next;
	}

	private static int[] next0(String pattern) {
		char[] chars = pattern.toCharArray();
		int[] next = new int[chars.length];

		next[0] = -1;
		int n = -1;
		int i = 0;
		// chars[n]表示前缀，chars[i]表示后缀
		int iMax = chars.length - 1;

		while (i < iMax) {
			if (n < 0 || chars[i] == chars[n])
				next[++i] = ++n;
			else
				n = next[n];
		}
		return next;
	}

}
