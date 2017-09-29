package nowcoder;

public class FindNum {
	 public static boolean Find(int target, int [][] array) {
         for(int i=0;i< array.length;i++){
             for(int j=0;j< array[i].length;j++){
            	 System.out.println(array[0].length);
                     if(target==array[i][j]){
                         return true;
                     }
             }
         }
		return false;
    }
	/* 两种思路
	 一种是：
	 把每一行看成有序递增的数组，
	 利用二分查找，
	 通过遍历每一行得到答案，
	 时间复杂度是nlogn*/
	  public boolean Find(int [][] array,int target) {
	          
	         for(int i=0;i<array.length;i++){
	             int low=0;
	             int high=array[i].length-1;
	             while(low<=high){
	                 int mid=(low+high)/2;
	                 if(target>array[i][mid])
	                     low=mid+1;
	                 else if(target<array[i][mid])
	                     high=mid-1;
	                 else
	                     return true;
	             }
	         }
	         return false;
	  
	     }
	 
	  
	/* 另外一种思路是：
	 利用二维数组由上到下，由左到右递增的规律，
	 那么选取右上角或者左下角的元素a[row][col]与target进行比较，
	 当target小于元素a[row][col]时，那么target必定在元素a所在行的左边,
	 即col--；
	 当target大于元素a[row][col]时，那么target必定在元素a所在列的下边,
	 即row++；*/
	     public boolean Find2(int [][] array,int target) {
	         int row=0;
	         int col=array[0].length-1;
	         while(row<=array.length-1&&col>=0){
	             if(target==array[row][col])
	                 return true;
	             else if(target>array[row][col])
	                 row++;
	             else
	                 col--;
	         }
	         return false;
	  
	     }
	 
	 public static String replaceSpace(StringBuffer str) {
	    	String newStr = str.toString().replaceAll(" ", "%20");
	    	return newStr;
	    	
	    }
	 public static void main(String[] args) {
		 int[][] a ={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		System.out.println(FindNum.Find(7, a));
            System.out.println(replaceSpace(new StringBuffer("We Are Happy")));
	 }
}
