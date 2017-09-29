package leetcode;

public class LongestSubstringWithoutRepeat {
    
	public int lengthOfLongestSubstring(String s) {
	    int max =1;
	    String res =s.substring(0, 1);  //比较过的字符串
	    for(int i = 1; i < s.length(); i++){
		      if(!res.contains(s.substring(i,i+1))){
		    	  res+=s.substring(i, i+1);
		    	  max=max>res.length()?max:res.length();
		      }else{
		    	  res=res.substring(res.indexOf(s.substring(i,i+1))+1, res.length())+s.substring(i,i+1);
		      }
	   }
	    return max;
    }
	public static void main(String[] args) {
		String s ="hghghg";
		System.out.println(s.substring(1, 2));
		System.out.println(s.indexOf("g"));
		System.out.println(new LongestSubstringWithoutRepeat().lengthOfLongestSubstring("bpfbhmipx"));
	}
}
