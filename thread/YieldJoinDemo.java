package thread;

public class YieldJoinDemo implements Runnable {

	@Override
	public void run() {
        System.out.println("frist:"+Thread.currentThread().getName());
        Thread.currentThread().yield();
        System.out.println("second:"+Thread.currentThread().getName());
	}
  public static void main(String[] args) throws InterruptedException {
//	    YieldJoinDemo yjd = new YieldJoinDemo();
//	    Thread t1 = new Thread(yjd);
//	    Thread t2 = new Thread(yjd);
//	    Thread t3 = new Thread(yjd);
//	    t2.setPriority(t2.getPriority()+1);
//	    t1.start();
//	    t2.start();
//	    t3.start();
	  Thread t1 = new Thread(){
		  public void run(){
			  try {
				  System.out.println("frist");
				  Thread.sleep(1000);
			} catch (InterruptedException e) {
                e.printStackTrace();
             }
			  System.out.println("second");
		  }
	  };
	  t1.start();
	 // t1.join();
	  Thread t2 = new Thread(){
		  public void run(){
			  try {
				  System.out.println("thrid");
				  t1.join();   //second 肯定在forth前面
			} catch (Exception e) {
                e.printStackTrace();
             }
			  System.out.println("forth");
		  }
	  };
	  t2.start();
   }
}
