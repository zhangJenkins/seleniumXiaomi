package selenium.test.util;

import java.io.File;
import java.io.IOException;

public class FilePath {
	public static void main(String[] args) {  
        
        File file1 = new File(".");  
        //File file1 = new File("test1.txt");  
          
        File file2 = new File("./bin/2.properties");  
        //File file2 = new File("bin/2.properties");  
          
        File file3 = new File("./bin/com/ghs/test/3.properties");  
        //File file3 = new File("bin/com/ghs/test/3.properties");  
  
        File file4 = new File("./bin/com/ghs/test/sub/4.properties");  
        //File file4 = new File("bin/com/ghs/test/sub/4.properties");  
          
        try {  
            System.out.println(file1.exists()+":"+file1.getCanonicalPath());  
            System.out.println(file2.exists()+":"+file2.getCanonicalPath());  
            System.out.println(file3.exists()+":"+file3.getCanonicalPath());  
            System.out.println(file4.exists()+":"+file4.getCanonicalPath());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}
