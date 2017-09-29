package classloaddemo;

public class ClassInfo {
   static{
	   System.out.println("forName执行静态块");
   }
   ClassInfo(){
	   System.out.println("ClassInfo构造方法");
   }
}
