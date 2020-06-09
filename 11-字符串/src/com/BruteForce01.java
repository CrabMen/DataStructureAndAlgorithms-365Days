package com;

public class BruteForce01 {
	
	public static int indexOf(String text, String pattern) {
		if (text == null || pattern == null) return -1;
		char[] textChars = text.toCharArray();
		int tlen = textChars.length;
		if (tlen == 0) return -1;
		char[] patternChars = pattern.toCharArray();
		int plen = patternChars.length;
		if (plen == 0) return -1;
		if (tlen < plen) return -1;
		
		int pi = 0, ti = 0, lenDelta = tlen - plen;
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
	
	public static int indexOf2(String text, String pattern) {
		if (text == null || pattern == null) return -1;
		char[] textChars = text.toCharArray();
		int tlen = textChars.length;
		if (tlen == 0) return -1;
		char[] patternChars = pattern.toCharArray();
		int plen = patternChars.length;
		if (plen == 0) return -1;
		if (tlen < plen) return -1;
		
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
