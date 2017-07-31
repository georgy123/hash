package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
 * JDK的动态代理
 *
 *@author {wqz}
 *
 * @date 2017年7月14日 下午4:00:56
 */
public class JDKDynamicProxy implements InvocationHandler {
    private Object target;
     public JDKDynamicProxy(Object _target) {
         target = _target;
    }
     @SuppressWarnings("unchecked")
     public <T> T getProxy(){
    	 return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
     }
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        	before();
        	Object result = method.invoke(target, args);
        	after();
		return result;
	}
	private void before(){
		System.out.println("Before");
	}
	private void after(){
		System.out.println("After");
	}
}
