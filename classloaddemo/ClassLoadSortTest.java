package classloaddemo;
/**
 *  在类的加载过程中，静态成员类的对象，静态代码块，只有内部的变量创建完，才会去执行这个类的构造方法
 * 
 *
 *@author {wqz}
 *
 * @date 2017年8月5日 下午3:20:41
 */
class A2{
    static B2 b2 = new B2();
    static{
        System.out.println("A static");
    }
    public A2() {
        System.out.println("A2()");
    }
}
class B2{
    C2 c2 = new C2();
    static D2 d2 = new D2();
    static{
        System.out.println("B static");
    }
    public B2() {
        System.out.println("B2()");
    }
}
class C2{
    static{
        System.out.println("C static");
    }
    public C2() {
        System.out.println("C2()");
    }
}
class D2{
    static{
        System.out.println("D static");
    }
    public D2() {
        System.out.println("D2()");
    }
}
public class ClassLoadSortTest {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        A2 a2 = new A2();
        System.out.println("*************************************************");
        Class<?> a = Class.forName("classloaddemo.ClassInfo");
        ClassLoadSortTest.class.getClassLoader().loadClass("classloaddemo.ClassInfo");//不加载静态块
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }
}
