package reflection;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.io.CharStreams;

/**
 * 模拟对象池
 * 模拟Spring实现一个简单的对象池, 该对象池会根据文件读取key-value对, 然后创建这些对象, 并放入Map中.
 *  参考：http://www.importnew.com/17616.html
 *@author {wqz}
 *
 * @date 2017年7月30日 下午7:41:47
 */
public class ObjectPool {
    private Map<String,Object> pool;
    private ObjectPool(Map<String,Object>  pool){
    	this.pool = pool;
    }
    private static Object getInstance(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
    	return Class.forName(className).newInstance();
    }
    private static JSONArray getObjects(String config) throws IOException{
    	Reader reader = new InputStreamReader(ClassLoader.getSystemResourceAsStream(config));
    	return JSONObject.parseObject(CharStreams.toString(reader)).getJSONArray("objects");
    }
    public static ObjectPool init(String config){
    	try{
    		  JSONArray objects = getObjects(config);
    		  ObjectPool pool = new ObjectPool(new HashMap<String,Object>());
    		  if(objects!=null && objects.size()!=0){
    			  for(int i=0; i< objects.size();i++){
    				  JSONObject object = objects.getJSONObject(i);
    				  if(object == null || object.size()==0){
    					  continue;
    				  }
    				  String id = object.getString("id");
    				  //System.out.println("dkjfkjdkjfk"+id);
    				  String className = object.getString("class");
    				  pool.putObject(id,getInstance(className));
    			  }
    		  }
    		  return pool;
    	}catch(IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
    	}
    }
    public Object getObject(String id){
    	return pool.get(id);
    }
    public void putObject(String id,Object object){
    	pool.put(id, object);
    }
    public void clear(){
    	pool.clear();
    }
}
