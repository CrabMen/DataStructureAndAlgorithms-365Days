package com.sequence;

public class BruteForce01 {

	public static int indexOf(String text, String pattern) {
		return indexOf1(text, pattern);
	}

	public static int indexOf1(String text, String pattern) {

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

		int pi = 0, ti = 0, lenDelta = tlen - plen;
		// ti - pi 为当前对比字符串的起始位置idx,优化掉一部分比较的次数
		while (pi < plen && ti - pi <= lenDelta) {
			if (textChars[ti] == patternChars[pi]) {
				ti++;
				pi++;
			} else {
				ti -= pi - 1;
				pi = 0;
			}
		}
		return (pi == plen) ? (ti - pi) : -1;
	}

	public static int indexOf0(String text, String pattern) {

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

		int pi = 0, ti = 0;
		while (pi < plen && ti < tlen) {
			if (textChars[ti] == patternChars[pi]) {
				ti++;
				pi++;
			} else {
				ti -= pi - 1;
				pi = 0;
			}
		}
		return (pi == plen) ? (ti - pi) : -1;

	}
}
