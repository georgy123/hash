package transient_test;

import java.io.Serializable;

public class UserInfoForTransient implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7561360353353100053L;
	private String name;
    //private transient String pwd;
	private String pwd;

    public UserInfoForTransient (){
    	
    }
	public UserInfoForTransient(String name, String pwd) {
		this.name = name;
		this.pwd = pwd;
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
    @Override
    public String toString() {
    	return "name:"+name+",pwd:"+pwd;
    }
}
