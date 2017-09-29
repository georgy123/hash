package algorithms.test;

public class YiWeiOperation {
	 public static void main(String[] args) {
	        int number = 10;
	        //原始数二进制
	        printInfo(number);
	        number = number << 1;
	        //左移一位
	        printInfo(number);
	        number = number >> 1;
	        //右移一位
	        printInfo(number);
	        int a =Integer.parseInt("1110101", 2); //二进制转十进制
	        int b = Integer.parseInt("0000101", 2);
	        System.out.println(Integer.toBinaryString(a^b));
	        System.out.println();
	    }
	    
	    /**
	     * 输出一个int的二进制数
	     * @param num
	     */
	    private static void printInfo(int num){
	        System.out.println(Integer.toBinaryString(num));
	    }
}
