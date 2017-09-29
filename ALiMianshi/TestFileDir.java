package ALiMianshi;

import java.io.File;

public class TestFileDir {
     public static void testLoopOutfile(String dirpath){
    	 if(dirpath==null) return;
    	 File[] listFiles = new File(dirpath).listFiles();
    	 if(listFiles==null) return;
    	 for (File file : listFiles) {
			if(file.isFile())
				System.out.println(file.getName());
			else if(file.isDirectory()){
				System.out.println(file.getName()+" is a dir,its files as fllow!");
				testLoopOutfile(file.getPath());
			}else
				System.out.println("read error!");
		}
     }
     public static void main(String[] args) {
		TestFileDir.testLoopOutfile("F:\\面试试题\\Java并发");
	}
}
