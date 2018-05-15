package xm;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;  
import com.gargoylesoftware.htmlunit.html.HtmlInput;  
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

import org.testng.annotations.Test;

 

public class HtmlunitTest {

	@Test  
    public void test() throws IOException {  
        WebClient webClient = new  WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(false);  
        webClient.getOptions().setCssEnabled(false);  
        webClient.getOptions().setUseInsecureSSL(false);  
  
  
        //获取页面  
        String url ="https://www.baidu.com/";  
        HtmlPage page = webClient.getPage(url);  

        System.out.println("页面文本:"+page.getTitleText()); 
  
        //获取页面元素  
        HtmlInput htmlInput = page.getHtmlElementById("kw");  
        System.out.println(htmlInput.asText());  
        
        HtmlPage pageNews  =  page.getElementByName("tj_trnews").click();
        System.out.println( "pageaa.getTitleText() " + pageNews.getTitleText());
        
        
        //System.out.println(htmlInput + "****************");
        htmlInput.setValueAttribute("test");  
  
        HtmlInput btn = page.getHtmlElementById("su");  
        HtmlPage page2 = btn.click();  
  
        System.out.println("页面2:"+page2.getTitleText());
	}
}
	
