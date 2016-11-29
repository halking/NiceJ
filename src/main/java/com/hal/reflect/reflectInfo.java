package com.hal.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.hal.entity.Student;

public class reflectInfo {

	public static void main(String[] args) throws IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		 try {
			Class<?> clazz = Class.forName("com.hal.entity.Student");
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				System.out.println("field name:"+field.getName());
			}
			Method[] methods = clazz.getDeclaredMethods();
			for (Method method : methods) {
				System.out.println("method name:"+method.getName());
			}
			Object object = clazz.newInstance();
			System.out.println(object.getClass().getName());
			Method method = clazz.getDeclaredMethod("writeSome",String.class);
			method.invoke(object,"steven");
		} catch (ClassNotFoundException ec) {
			// TODO Auto-generated catch block
			ec.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
   public void getClazz(){
	    
   }
}
