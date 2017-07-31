package reflection;

import org.junit.Test;

public class Client {
    @Test
	public void client(){
		ObjectPool pool = ObjectPool.init("config.json");
		User user =(User)pool.getObject("id1");
		System.out.println(user);
		Bean bean =(Bean)pool.getObject("id2");
		System.out.println(bean);
	}
}
