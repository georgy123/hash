package basic;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class ReferentceDemo {
  public static void main(String[] args) {
	    String str = "hello"; //①   
	    ReferenceQueue<String> rq = new ReferenceQueue<String>(); //②   
	    WeakReference<String> wf = new WeakReference<String>(str, rq); //③  
	    str=null; //④取消"hello"对象的强引用  
	    System.gc();
	    System.gc();
	    String str1=wf.get(); //⑤假如"hello"对象没有被回收，str1引用"hello"对象  
	    //假如"hello"对象没有被回收，rq.poll()返回null  
	    Reference<? extends String> ref=rq.poll(); //⑥  
	    System.out.println("str1:"+str1);
	    System.out.println("ref:"+ref);
}
}
