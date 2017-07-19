package hash;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class ServerLoadBalance {
    private TreeMap<Long,Sever> nodes;
    private List<Sever> servers;
    private final int NODE_NUM = 200;
	public ServerLoadBalance(List<Sever> servers) {
		super();
		this.servers = servers;
		init();
	}
    private void init(){  //初始化一致性hash环
    	nodes = new TreeMap<Long,Sever>();
    	for (int i = 0; i != servers.size(); i++) {  //每个真实机器节点都需要关联虚拟节点 ，缓冲对象和服务器都映射到hash环上
    		final Sever shardInfo = servers.get(i);
             for(int n = 0; n <  NODE_NUM; n++){
        	    //一个真实机器节点关联NODE_NUM个虚拟节点
        	    Long hash_value = hash("SHARD-"+shardInfo.getIp()+"-NODE-"+n);
        	    //System.out.println("第"+i+"个server的hash 散列值="+hash_value);
             	nodes.put(hash_value, shardInfo);
        } 
      }
    	System.out.println("finish inited virtual node ...");
    }
    /**
     * 通过key的一致性hash值得到相应的server对象
     * @param key
     * @return
     */
    public Sever getShardInfo(String key){
    	Long hash_value = hash(key);
    	//System.out.println("key="+key+"的hash值="+hash_value);
    	SortedMap<Long, Sever> tail = nodes.tailMap(hash_value);  //沿环的顺时针找到一个虚拟点    返回大于等于hash_value的值 如tailmap（3） key值3，4，5
    	if(tail.size()==0){
    		return nodes.get(nodes.firstKey());   //沿环的顺时针找到第一个一个虚拟点
    	}
    	return tail.get(tail.firstKey());
    }
    /**
     * 一致性hash算法
     * @param key
     * @return
     */
	private Long hash(String key) {
		ByteBuffer buf = ByteBuffer.wrap(key.getBytes());
		int seed = 0x1234ABCD;
		ByteOrder byteOrder = buf.order();  //返回字节序 ，数据在内存的存储情况
		buf.order(byteOrder.LITTLE_ENDIAN); //小字节序 低位存在低位上
		long m = 0xc6a4a7935bd1e995l;
		int r =47;   //移动位数
		long h = seed ^ (buf.remaining()*m);  // 	remaining return limit - position;返回limit和position之间相对位置差  
		long k;
		while(buf.remaining()>= 8){
			k = buf.getLong();
			k*=m;
			k^=k>>>r;
			k*=m;
			h ^=k;
			h*=m;
		}
		if(buf.remaining()>0){
			ByteBuffer finish = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
			finish.put(buf).rewind();
			h ^= finish.getLong();   //byteBuffer.getLong()：读取此缓冲区的当前位置之后的 8 个字节，根据当前的字节 顺序将它们组成 long 值，然后将该位置增加 8
			h*=m;
		} 
		 h ^=h>>>r;
		 h*=m;
		 h^=h>>>r;
		 buf.order(byteOrder);
		return h;
	}
}
