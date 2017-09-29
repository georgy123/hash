package sort;

import java.util.Arrays;

import ACM_challenge.DrawProblem;

public class MergeSort {
 public static void mergeSort(int[] data,int left,int right){
	 if(left>=right) return;
	 int mid = (left+right)/2;
	 mergeSort(data,left,mid);
	 mergeSort(data,mid+1,right);
	 merge(data,left,mid,right);
 }
 public static void merge(int[] data, int left,int center,int right){
	 int[] temData = new int[data.length];   //辅助数组
	 int mid = center+1;  //右边数组第一个数
	 int dataleft = left;  //左数组第一个数
	 int tmpleft = left;    //临时数组的总的下标
	 while(left<=center && mid<=right){
		 if(data[left]<=data[mid]){
			 temData[tmpleft++] = data[left++];
		 }else{
			 temData[tmpleft++] = data[mid++];
		 }
	 }
	 while(mid<=right){
		 temData[tmpleft++] = data[mid++];  //右数组没有完
	 }
	 while(left<=center){
		 temData[tmpleft++] = data[left++];
	 }
	 while(dataleft<=right)
	 {
		 data[dataleft]=temData[dataleft++];
	 }
 }
 public static void main(String[] args) {
	 int[] a=DrawProblem.randomNum(10000);
	 int[] b = { 49, 38, 65, 97, 76, 13, 27, 50 };
	 long start = System.currentTimeMillis();
     mergeSort(a, 0, a.length - 1);
	 //DrawProblem.quickSort(a,0,a.length-1);
     long end = System.currentTimeMillis();
     System.out.println((end-start));
     System.out.println(Arrays.toString(a));
}
}
