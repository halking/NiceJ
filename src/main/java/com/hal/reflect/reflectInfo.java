package com.hal.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.hal.entity.Student;

public class reflectInfo {

	public static void main(String[] args) throws IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		 try {
			Class<?> clazz = Class.forName("com.hal.entity.Student");
			Object object = clazz.newInstance();
			System.out.println(object.getClass().getName());
			Method method = clazz.getDeclaredMethod("writeSome",String.class);
			method.invoke(object,"steven");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
   public void getClazz(){
	    
   }
}
