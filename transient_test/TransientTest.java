package transient_test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransientTest {
	public static void main(String[] args) {
		UserInfoForTransient user = new UserInfoForTransient("zhangsan", "1212121212");
		try {
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("UserInfoForTransient.out"));
			o.writeObject(user);
			o.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("UserInfoForTransient.out"));
			UserInfoForTransient ruser = (UserInfoForTransient)in.readObject();
			System.out.println(ruser.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
