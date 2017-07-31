package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PersonReflectTest {
	//获取class的3种方式
	public static void getClazz(){
		 
		   //第一种
		   try{
		    	  Class<?> c1 = Class.forName("reflection.Person");
		    	  System.out.println(c1);
		      }catch(ClassNotFoundException e){
		    	  e.printStackTrace();
		      }
		   //第二种
		   Class<?> c2 = Person.class;
		   //第三种
		   Person p = new Person();
		   Class<?> c3 = p.getClass();
		   System.out.println(c2);
		   System.out.println(c3);
	}
	/**
	 * 获取获取所有的方法包括父类
	 * @throws ClassNotFoundException
	 */
	public static void testMethods() throws ClassNotFoundException{
		 Class<?> c1 = Class.forName("reflection.Person");
		 Method[] methods = c1.getMethods();
		 for(Method m:methods){
			 System.out.println(m);
		 }
	}
	/**
	 * 获取实现的借口
	 * @throws ClassNotFoundException
	 */
	public static void testInterfaces() throws ClassNotFoundException{
		 Class<?> c1 = Class.forName("reflection.Person");
		 Class<?>[] intfs = c1.getInterfaces();
		 for(Class<?> intf:intfs){
			 System.out.println(intf);
		 }
	}
	/**
	 * 获取父类
	 * @throws ClassNotFoundException
	 */
	public static void testSuperClass() throws ClassNotFoundException{
		 Class<?> c1 = Class.forName("reflection.Person");
		 Class<?> supercs = c1.getSuperclass();
	     System.out.println(supercs);
		  
	}
	/**
	 * 获取所有的构造方法
	 * @throws ClassNotFoundException
	 */
	public static void testConstructors() throws ClassNotFoundException{
		 Class<?> c1 = Class.forName("reflection.Person");
		 Constructor<?>[] constructors = c1.getConstructors();
		 for(Constructor<?> constr:constructors){
			 System.out.println(constr);
		 }
	}
	/**
	 * 获取所有属性
	 *  getDeclaredFields 和 getFields 的区别
       getDeclaredFields()获得某个类的所有申明的字段，即包括public、private和proteced，但是不包括父类的申明字段。
       getFields()获得某个类的所有的公共（public）的字段，包括父类。
	 * @throws ClassNotFoundException
	 */
	public static void testDeclaredFields() throws ClassNotFoundException{
		 Class<?> c1 = Class.forName("reflection.Person");
		 Field[] dfields = c1.getDeclaredFields();
		 Field[] fields = c1.getFields();
		 for(Field dfield:dfields){
			 System.out.println("dfield:"+dfield);
		 }
		 for (Field field : fields) {
			System.out.println("field:"+field);
		}
	}
	/**
	 * newIntance
	 * @throws ClassNotFoundException
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 */
	public static void testNewIntance() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		Class<?> c1 = Class.forName("reflection.Person");
		try {
			Object object = c1.newInstance();  //class对象动态生成 1
			Constructor<?> constructor = c1.getDeclaredConstructor(new Class[]{int.class});
			Person p1 =(Person) constructor.newInstance(new Object[]{1});
			p1.setAge(14);
			System.out.println("p1:"+p1.getAge());
			Person p2 =(Person)object;
			p2.setAge(12);
			System.out.println(p2.getAge());
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
   public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
	  PersonReflectTest.getClazz();
	  System.out.println("-----------------------------------------------------");
	  PersonReflectTest.testMethods();
	  System.out.println("-----------------------------------------------------");
	  PersonReflectTest.testInterfaces();
	  System.out.println("-----------------------------------------------------");
	  PersonReflectTest.testSuperClass();
	  System.out.println("-----------------------------------------------------");
	  PersonReflectTest.testConstructors();
	  System.out.println("-----------------------------------------------------");
	  PersonReflectTest.testDeclaredFields();
	  System.out.println("-----------------------------------------------------");
	  PersonReflectTest.testNewIntance();
}
     
}
