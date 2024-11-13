package api.endpoints;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
	
public void verify_Link(String link)
{
	
	try {
		URL url = new URL(link);
		HttpURLConnection htp = (HttpURLConnection)url.openConnection();
		htp.setConnectTimeout(5000);
		htp.connect();
		if(htp.getResponseCode()>=400)
		{
			System.out.println(link +" is invalid");
		}
		else
		{
			System.out.println(link +" is valid");
		}
	} catch (Exception e) {
		
		e.printStackTrace();
	}
			
}
public void link()
{
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.javatpoint.com/");
	List<WebElement> tag =driver.findElements(By.tagName("a"));
	for(int i=0;i<tag.size();i++)
	{
		String link = tag.get(i).getAttribute("href");
		verify_Link(link);
	}
	
}
public static void main(String[] args) {
	Test1 ob = new Test1();
//	ob.link();
	String str1 = "Hello world";
	String str2 = "Hello world";
	String str3 = new String("Hello world");
	System.out.println(str1==str2);
	System.out.println(str1==str3);
	System.out.println(str1.equals(str2));
	System.out.println(str1.equals(str3));
}
}
