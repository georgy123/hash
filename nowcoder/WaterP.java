package nowcoder;
/**
 * 论坛中“水王”发帖的数目超过了帖子总数的一半，如果有当前论坛所有帖子的列表，求“水王”的ID。
 * 
 *
 *@author {wqz}
 *
 * @date 2017年9月21日 下午5:04:40
 */
public class WaterP {
 
	/**
	 * 每次从列表中删除两个不同的ID（不管是否包括“水王”的ID），这并不影响水王的ID在剩余ID中仍然超过一半这一事实，
	 * 因此每次删除两个不同的ID，直到剩下的所有ID都相同，那么剩下ID的就是水王的ID。
	 * @param a
	 * @return id
	 */
	public static int findID(int[]a){
		int id=0; //要找的id
		int count=0; //重复的次数
		for(int i=0;i<a.length;i++){
			if(count==0){     //id重新赋值
				id = a[i];
				count=1;
			}else {if(id==a[i]){
				count++;
			}else{
				count--;
			}
			}
		}
		return id; 
	}
	public static void main(String[] args) {
		int[] a={1,2,1,3,1,5,1,4,1,6,1};
		System.out.println(WaterP.findID(a));
	}
}
