package selenium.crawler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import common.Util;

public class zhilianzhaopin {
	@Test  
    public void test() throws IOException {  
        WebClient webClient = new  WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(false);  
        webClient.getOptions().setCssEnabled(false);  
        webClient.getOptions().setUseInsecureSSL(false);  
   
        List<String> urlList =  getZlzpUrl(webClient);
        
       for (String url : urlList) {
        List<String> baseInfoList = new ArrayList<>();
        	HtmlPage page = webClient.getPage(url);  
        	List<DomElement> bodyElementList = page.getElementsByTagName("body");
        	List<HtmlElement> divElementList = bodyElementList.get(0).getElementsByTagName("div");
        	for (HtmlElement htmlElement : divElementList) {
        		String classAttr = htmlElement.getAttribute("class");
        		if (classAttr != null || classAttr != "") {
					if (classAttr.equals("top-fixed-box")) {
						List<HtmlElement> terminadivElementList = htmlElement.getElementsByTagName("div");
						List<HtmlElement> h1vElementList =terminadivElementList.get(0).getElementsByTagName("h1");
						String h1Text = h1vElementList.get(0).getTextContent();
						List<HtmlElement> h2vElementList =terminadivElementList.get(0).getElementsByTagName("h2");
						String h2Text = h2vElementList.get(0).getTextContent();
						baseInfoList.add(h1Text);
						baseInfoList.add(h2Text);
					}
					else if(classAttr.equals("terminalpage clearfix")){
						List<HtmlElement> terminadivElementList = htmlElement.getElementsByTagName("div");
						List<HtmlElement> firstUlElementList = terminadivElementList.get(0).getElementsByTagName("ul");
						List<HtmlElement> firstLiElementList = firstUlElementList.get(0).getElementsByTagName("li");
						for (HtmlElement liElement : firstLiElementList) {
							String temp =  liElement.getTextContent();
							baseInfoList.add(temp);
						}
						
						List<HtmlElement> firstdivElementList = terminadivElementList.get(0).getElementsByTagName("div");
						List<HtmlElement> detaildivElementList = firstdivElementList.get(0).getElementsByTagName("div");
						List<HtmlElement> pElementList = detaildivElementList.get(0).getElementsByTagName("p");
						int i = 0;
						while (i < 3) {
							String temp =  pElementList.get(i).getTextContent();
							i = i+2;
							baseInfoList.add(temp);
						}							
					}
				}
        		
			}
        	String text  = baseInfoList.toString();
        	Util.writeStringToText(text);;
        	 System.out.println(text);
		}
          
	}

	private List<String> getZlzpUrl(WebClient webClient) throws IOException, MalformedURLException {
		List<String> urlList = new ArrayList<>();
		for (int pageNum = 1; pageNum <= 12; pageNum++) {
        	String url ="http://sou.zhaopin.com/jobs/searchresult.ashx?jl=%E9%80%89%E6%8B%A9%E5%9C%B0%E5%8C%BA&kw=%E8%87%AA%E5%8A%A8%E5%8C%96%E6%B5%8B%E8%AF%95%E5%B7%A5%E7%A8%8B%E5%B8%88&p="
        			+ pageNum
        			+ "&isadv=0";  
            HtmlPage page = webClient.getPage(url);  
//          System.out.println("页面文本:"+page.getTitleText()); 
            
            DomElement  talbleElement = page.getElementById("newlist_list_content_table");
            List<HtmlElement> talbleElementList =   talbleElement.getElementsByTagName("table");
            System.out.println("size:　" + talbleElementList.size());
            for (int i = 1; i < talbleElementList.size(); i++) {
            	 List<HtmlElement> trElementList = talbleElementList.get(i).getElementsByTagName("tr");	
            	 List<HtmlElement> divElementList = trElementList.get(0).getElementsByTagName("div");
            	 List<HtmlElement> aElementList = divElementList.get(0).getElementsByTagName("a");
            	 String htef = aElementList.get(0).getAttribute("href");
            	 System.out.println(pageNum + "---" + i + "---" + htef);
            	 urlList.add(htef);
            }	
		}
		
		return urlList;
	}
}
