package com.hal.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create a target instance	
		invokeNewProxy();
	}
   public static void invokeNewProxy(){
	   System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		BaseProxy targetBean = new TargetBean();
		//create a proxy instance
		BaseProxy proxy =(BaseProxy) Proxy.newProxyInstance(BaseProxy.class.getClassLoader(),
			     targetBean.getClass().getInterfaces(),
				new ProxyBean(targetBean));
		//invoke the target instance method through the proxy
		 proxy.sayHello();
   }
   
   public static void invokeByreflect() throws Exception{
	   
	    Class proxy = Proxy.getProxyClass(BaseProxy.class.getClassLoader(), BaseProxy.class);
	    Constructor  constructor = proxy.getConstructor(InvocationHandler.class);
	    BaseProxy baseProxy = (BaseProxy)constructor.newInstance(new ProxyBean(new TargetBean()));
	    baseProxy.sayHello();
   }
}
