package selenium.crawler;

public class MainThread {

	   public static void main(String[] args) {  
	       Thread thread =  new Thread(new CsdnCrawler(),"thread_1")  ;  
	       thread.start();
	       
//	       Thread thread1 =  new Thread(new CsdnCrawler(),"thread_2")  ;  
//	       thread1.start();
//	       
//	       Thread thread2 =  new Thread(new CsdnCrawler(),"thread_3")  ;  
//	       thread2.start();
	    }  
}
