package hash;
/**
 * 
 * 参考http://xiaoliang330.iteye.com/blog/2167162
 *
 *@author {wqz}
 *
 * @date 2017年7月19日 下午2:24:47
 * 
 * 服务器对象
 */
public class Sever {
	private String name;
	private String pwd;
	private String ip;
	private String port;

	public Sever() {
	}

	public Sever(String name, String pwd, String ip, String port) {
		this.name = name;
		this.pwd = pwd;
		this.ip = ip;
		this.port = port;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "name:" + name + "ip:" + ip + "port:" + port;
	}
}
