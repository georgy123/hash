package algorithms.test;

public class VolatileAtoTest implements Runnable {
	volatile  static int i = 0;

	@Override
	public void run() {
		for (int k = 0; k < 1000; k++) {
			i++;
		}
	}
	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[10];
		for (int c = 0; c < 10; c++) {
			threads[c] = new Thread(new VolatileAtoTest());
			threads[c].start();
		}
		for (int c = 0; c < 10; c++) {
			threads[c].join();
		}
		System.out.println(i);
	}

}
