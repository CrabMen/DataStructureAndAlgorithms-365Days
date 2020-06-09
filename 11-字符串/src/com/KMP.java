package com;

public class KMP {

	public static int indexOf(String text, String pattern) {
		if (text == null || pattern == null) return -1;
		char[] textChars = text.toCharArray();
		int tlen = textChars.length;
		if (tlen == 0) return -1;
		char[] patternChars = pattern.toCharArray();
		int plen = patternChars.length;
		if (plen == 0) return -1;
		if (tlen < plen) return -1;
		
		// next表
		int[] next = next(pattern);
		
		int pi = 0, ti = 0, lenDelta = tlen - plen;
		while (pi < plen && ti - pi <= lenDelta) {
			if (pi < 0 || textChars[ti] == patternChars[pi]) {
				ti++;
				pi++;
			} else {
				pi = next[pi];
			}
		}
		return (pi == plen) ? (ti - pi) : -1;
	}
	
	private static int[] next(String pattern) {
		char[] chars = pattern.toCharArray();
		int[] next = new int[chars.length];
		
		// n == next[i]
		next[0] = -1;
		int i = 0;
		int n = -1;
		int iMax = chars.length - 1;
		while (i < iMax) {
			if (n < 0 || chars[i] == chars[n]) {
				++i;
				++n;

				if (chars[i] == chars[n]) {
					next[i] = next[n];
				} else {
					next[i] = n;
				}
			} else {
				n = next[n];
			}
		}
		return next;
	}
	
	private static int[] next2(String pattern) {
		char[] chars = pattern.toCharArray();
		int[] next = new int[chars.length];
		
		// n == next[i]
		next[0] = -1;
		int i = 0;
		int n = -1;
		int iMax = chars.length - 1;
		while (i < iMax) {
			if (n < 0 || chars[i] == chars[n]) {
				next[++i] = ++n;
			} else {
				n = next[n];
			}
		}
		return next;
	}
	
}
