package com.hal.character;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String ch = "E6 1PY";
			boolean ch1 = ch.replaceAll("\\s", "").equals(ch.replaceAll("\\s", ""));
//			System.out.println(ch1);
			Pattern pattern = Pattern.compile("^[A-Za-z0-9]{8,}$");
			Matcher matcher = pattern.matcher("Test1234aaa");
			System.out.println(matcher.matches());
	}

}
