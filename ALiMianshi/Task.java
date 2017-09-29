package ALiMianshi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * 
 * 阿里巴巴的ODPS大数据处理平台可以启动一系列并发的作业，每个作业中存在一系列存在父子关系的任务。每个任务用一个三元组表示--（任务id，父任务id，
 * 执行开销），其中任务id是一个正整数（>0）；父任务id为0表示根任务，每个作业存在一个唯一的根任务，并且，所有的任务，如果其父任务id不为0，
 * 那么必然是一个已经存在的根任务id；执行开销是一个正整数（>0）。系统中至少存在一个作业。
 * 
 * 举例如下：
 * 
 * (1, 0, 2) (2, 0, 3) (3, 1, 2) (4, 1, 3)
 * 
 * 对应的任务关系是：
 * 
 * 1(2) 2(3)
 * 
 * / \
 * 
 * 3(2) 4(3)
 * 
 * 注：括号内的数字表示任务开销。
 * 
 * 很容易看出来，这些任务树构成了一个森林。每颗任务树有若干个叶子节点，从根节点到叶子结点的路径上所有的执行开销，称作叶子节点对应任务的总开销。
 * 例如上面一共有3个叶子节点任务，分别是任务3, 4和2，对应的总开销分别是4, 5和3。总开销最大的叶子节点任务是4，对应的总开销是5。
 * 
 * 现在需要编写程序，针对输入的任务数据，找到总开销最大的叶子节点任务对应的总开销，比如针对上面例子，输出5。
 * 
 *
 * 
 * @author Administrator
 *
 * @date 2017年7月7日 上午9:13:26
 */
public class Task {
	public static void main(String[] args) {
		ArrayList<Integer> _ids = new ArrayList<Integer>();
		ArrayList<Integer> _parents = new ArrayList<Integer>();
		ArrayList<Integer> _costs = new ArrayList<Integer>();

		Scanner in = new Scanner(System.in);
		String line = in.nextLine();

		while (line != null && !line.isEmpty()) {
			if (line.trim().equals("0"))
				break;
			String[] values = line.trim().split(" ");
			if (values.length != 3) {
				break;
			}
			_ids.add(Integer.parseInt(values[0]));
			_parents.add(Integer.parseInt(values[1]));
			_costs.add(Integer.parseInt(values[2]));
			line = in.nextLine();
		}
		long start = System.currentTimeMillis();
		int res = resolve(_ids, _parents, _costs);
        long end = System.currentTimeMillis();
		System.out.println(String.valueOf(res));
		System.out.println(end-start);
	}

	// write your code here
	public static int resolve(ArrayList<Integer> ids, ArrayList<Integer> parents, ArrayList<Integer> costs) {
		Map<Integer, Integer> tCosts = new HashMap<Integer, Integer>();
		for (int i = 0; i < ids.size(); i++) {
				if(tCosts.containsKey(parents.get(i)))
					tCosts.put(ids.get(i), costs.get(i)+tCosts.get(parents.get(i)));
				else
					tCosts.put(ids.get(i), costs.get(i));
		}
		int res = 0;
		Collection<Integer> values = tCosts.values();
		for (Integer integer : values) {
			if (res < integer) {
				res = integer;
			}
		}
//		 List<Map.Entry<Integer, Integer>> smaps = new ArrayList<Map.Entry<Integer,Integer>>(tCosts.entrySet());
//		 Collections.sort(smaps,(o1,o2)->{return o2.getValue().compareTo(o1.getValue());});
//		 return smaps.get(0).getValue();
		return res;
	}
}
