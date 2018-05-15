package common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class Util {

	@Test
	  public static void writeStringToText(String  text){
	        File file = new File("E:/dic_general.txt");
	        FileWriter fw = null;
	        BufferedWriter writer = null;
	        try {
	            fw = new FileWriter(file);
	            writer = new BufferedWriter(fw);
	            writer.write(text);
	            writer.newLine();//换行
	            writer.flush();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }catch (IOException e) {
	            e.printStackTrace();
	        }finally{
	            try {
	                writer.close();
	                fw.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	  
//	  @Test
	    public void writeToTxt(){
	        List<String> list = new ArrayList<>();
	        		list.add("中国");
	        list.add("美国");
	        list.add("英国");
	        list.add("俄罗斯");
	        
	       
	        File file = new File("E:/dic_general.txt");
	        FileWriter fw = null;
	        BufferedWriter writer = null;
	        try {
	            fw = new FileWriter(file);
	            writer = new BufferedWriter(fw);
	           for (String string : list) {
	                writer.write(string);
	                writer.newLine();//换行
	           }
	            writer.flush();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }catch (IOException e) {
	            e.printStackTrace();
	        }finally{
	            try {
	                writer.close();
	                fw.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
}
