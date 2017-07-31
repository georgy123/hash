package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectTest {
          public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        	  Foo foo = new Foo("这个一个Foo对象！");
              Class clazz = foo.getClass();
              Method m1 = clazz.getDeclaredMethod("outInfo");  //无参数的
              Method m2 = clazz.getDeclaredMethod("setMsg", String.class);   //得到要调用的类的方法
              Method m3 = clazz.getDeclaredMethod("getMsg");
              m1.invoke(foo);   //
              m2.invoke(foo, "重新设置msg信息！");  //方法调用(对象实例，参数)
              String msg = (String) m3.invoke(foo);
              System.out.println(msg);
              /*static方法直接调用不用newInstance
               * Class cls = Class.forName("chb.test.reflect.Student");  
              Method staticMethod = cls.getDeclaredMethod("hi",int.class,String.class);  
              staticMethod.invoke(cls,20,"chb");//这里不需要newInstance  */
              Field field = clazz.getDeclaredField("msg");
              field.setAccessible(true);//如果直接通过反射给类的private成员变量赋值，是不允许的，这时我们可以通过setAccessible方法解决。代码示例：
              field.set(foo, "能吗？");
              System.out.println(field.get(foo));
              Method[] methods = clazz.getDeclaredMethods();
              for (Method method : methods) {
				String name = method.getName();
				System.out.println(name);
				Class<?> returnType = method.getReturnType();
				System.out.println(returnType);
				Parameter[] parameters = method.getParameters();
				System.out.println(parameters.length);
				for (Parameter parameter : parameters) {
					System.out.println(parameter);
				}
			}
          } 
		}
class Foo{
	private String msg;
    
	public Foo(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	 public void outInfo() {
	        System.out.println("这是测试Java反射的测试类");
	    } 
}