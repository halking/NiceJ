package com.hal.base;

public class StringExe {
    
	String  s1 = new String("abc");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	StringExe sExe = new StringExe();
       System.out.println(sExe.s1);
//       sExe.s1="bcd";
       sExe.change(sExe.s1);
       System.out.println(sExe.s1);
	}
	public void change(String string) {
		 s1= "test";
	}

}
