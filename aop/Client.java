package aop;
/**
 * 
 * 参考http://developer.51cto.com/art/201309/410861.htm
 *
 *@author {wqz}
 *
 * @date 2017年7月19日 下午2:19:32
 */
public class Client {
   public static void main(String[] args) {
	     Greeting g = new JDKDynamicProxy(new GreetingImpl()).getProxy();
	     g.sayHello(" Jdk动态代理Georgy");
	     CGLibInfo cgLibInfo = CGLibDynamicProxy.getInstance().getProxy(CGLibInfo.class);
	     cgLibInfo.getMessage("hahah");
}
}
