package aop;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLibDynamicProxy implements MethodInterceptor {

	private static CGLibDynamicProxy instance = new CGLibDynamicProxy();
	private CGLibDynamicProxy(){
		
	}
	public static CGLibDynamicProxy getInstance(){
		return instance;
	}
	@SuppressWarnings("unchecked")
	public <T> T getProxy(Class<T> cls){
		return (T)Enhancer.create(cls, this);
	}
	@Override
	public Object intercept(Object target, Method arg1, Object[] arg2, MethodProxy proxy) throws Throwable {
		before();
		Object result = proxy.invokeSuper(target, arg2);
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
