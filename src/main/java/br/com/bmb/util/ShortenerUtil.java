package br.com.bmb.util;

import java.util.Random;

public class ShortenerUtil {

	private static final char[] tokens = {
			'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
			'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
			'0','1','2','3','4','5','6','7','8','9'
			};
	
	private static final int aliasSize = 5;
	
	public static final String createAlias() {
		String alias = "";
		
		Random rand = new Random();
		
		for(int i = 0; i < aliasSize; i++) {
			alias += tokens[rand.nextInt(tokens.length)];
		}
		
		return alias;
	}
}
