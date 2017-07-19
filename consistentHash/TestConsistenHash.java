package hash;

import java.util.ArrayList;
import java.util.List;

public class TestConsistenHash {
	
	//主要的测试类
	
		
		public static Sever s1 = new Sever("ser1", "123", "192.168.216.1", "1");
		public static Sever s2 = new Sever("ser2", "123", "192.168.216.2", "2");
		public static Sever s3 = new Sever("ser3", "123", "192.168.216.3", "3");
		public static Sever s4 = new Sever("ser4", "123", "192.168.216.4", "4");
		public static Sever s5 = new Sever("ser5", "123", "192.168.216.5", "5");
		public static List<Sever> list = new ArrayList<Sever>();
		
		public static int count1 = 0;
		public static int count2 = 0;
		public static int count3 = 0;
		public static int count4 = 0;
		public static int count5 = 0;
		
		
		public static void main(String[] args) {
			
			
			
			/**
			 * 可以通过  增加 / 剔除 server来测试 被点击量 的变化
			 */
			list.add(s1);
			list.add(s2);
			//list.add(s3);
			list.add(s4);
			list.add(s5);
			
			
			
			
			/**
			 * key的数量为1000个
			 * 
			 * 
			 * 
			 * 在ServerLoadBalance 的 virtual node 数量NODE_NUM 为200时（这个值能达到负载均衡了，100或更小时还没达到）
			 * 测试的两组数据（5台server和剔除server3时的4台server）
			 * 
			 * 
			 * server1 hit count = 197
			 * server2 hit count = 193
			 * server3 hit count = 210
			 * server4 hit count = 170
			 * server5 hit count = 230
			 * 
			 * 
			 * server1 hit count = 265
			 * server2 hit count = 248
			 * server3 hit count = 0
			 * server4 hit count = 214
			 * server5 hit count = 273
			 * 
			 * 
			 * 
			 * 
			 * 在ServerLoadBalance 的 virtual node 数量NODE_NUM 为1时（负载均衡在100或更小时还没达到）
			 * 测试的两组数据（5台server和剔除server3时的4台server）
			 * server1 hit count = 359
			 * server2 hit count = 94
			 * server3 hit count = 387
			 * server4 hit count = 67
			 * server5 hit count = 93
			 * 
			 * 
			 * server1 hit count = 359
			 * server2 hit count = 481
			 * server3 hit count = 0
			 * server4 hit count = 67
			 * server5 hit count = 93
			 * 
			 * 
			 * 
			 * 
			 */
			
			
	
			ServerLoadBalance server = new ServerLoadBalance(list);
			

			for (int i = 0; i < 1000; i++) {
				String key =  ""+(i+20);
				
				Sever s = (Sever)server.getShardInfo(key);
				if(s.toString().equals(s1.toString()))
					count1 ++;
				else if(s.toString().equals(s2.toString()))
					count2 ++;
				else if(s.toString().equals(s3.toString()))
					count3 ++;
				else if(s.toString().equals(s4.toString()))
					count4 ++;
				else
					count5 ++;
				
				//System.out.println("key" + i + ", server=" + s);
				
			}
			
			//得到各server的命中 情况
			System.out.println("#############");
			System.out.println("server1 hit count = "+TestConsistenHash.count1);
			System.out.println("server2 hit count = "+TestConsistenHash.count2);
			System.out.println("server3 hit count = "+TestConsistenHash.count3);
			System.out.println("server4 hit count = "+TestConsistenHash.count4);
			System.out.println("server5 hit count = "+TestConsistenHash.count5);
			System.out.println("#############");
			
//			String key = "test";
//			TestThread tt = new TestThread(shard, key);
//			
//			new Thread(tt, "0").start();
//			new Thread(tt, "10001").start();
//			new Thread(tt, "20001").start();
//			new Thread(tt, "30001").start();
//			new Thread(tt, "40001").start();
//			new Thread(tt, "50001").start();

			
		}

	}

