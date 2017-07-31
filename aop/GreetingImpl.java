package aop;

/**
 * Greeting接口的实现类
 * 
 *
 *@author Administrator
 *
 * @date 2017年7月14日 下午3:56:35
 */
public class GreetingImpl implements Greeting {

	@Override
	public void sayHello(String name) {
        System.out.println("Hello "+name+" !");
	}
	private void before(){
		System.out.println("Before");
	}
	private void after(){
		System.out.println("After");
	}

}
