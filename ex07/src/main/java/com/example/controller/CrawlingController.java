package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/crawl")
public class CrawlingController {
	@RequestMapping("/shop")
	public List<HashMap<String,Object>> shop(String query){
		List<HashMap<String,Object>> list =new ArrayList<HashMap<String,Object>>();
		try{
			System.setProperty("webdriver.chrome.driver", "c:/data/s/chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("https://shopping.naver.com/home");
			
			WebElement txtSearch=driver.findElement(By.className("_searchInput_search_text_3CUDs"));
			txtSearch.sendKeys(query);
			WebElement btnSearch=driver.findElement(By.className("_searchInput_button_search_1n1aw"));
			btnSearch.click();
			Thread.sleep(1000);
			 ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
			 Thread.sleep(2000);

			 
			 List<WebElement>es=driver.findElements(By.className("basicList_item__0T9JD"));
			 System.out.println("............2..........."+es.size());
			 int no=1;
			for(WebElement e:es){
				String title=e.findElement(By.className("basicList_link__JLQJf")).getText();
				System.out.println(no+":"+title);
				no++;
			}
		}catch(Exception e){
			System.out.println("CGV 오류:"+e.toString());
		}
		return list;
		
	}
	
	
	
	
	
	
	@RequestMapping("/cgv/more")
	public List<HashMap<String,Object>> more(){
		List<HashMap<String,Object>> list =new ArrayList<HashMap<String,Object>>();
		try{
			System.setProperty("webdriver.chrome.driver", "c:/data/s/chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("http://www.cgv.co.kr/movies/?lt=1&ft=0");
			WebElement more=driver.findElement(By.className("btn-more-fontbold"));
			more.click();
			Thread.sleep(1000);
			 ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
			 Thread.sleep(5000);


			List<WebElement> es =driver.findElements(By.cssSelector(".sect-movie-chart ol li")); 
			System.out.println("사이즈:" + es.size());
			int no=1;
			for(WebElement e:es){
				String title=e.findElement(By.className("title")).getText();
				String image=e.findElement(By.tagName("img")).getAttribute("src");
				String link=e.findElement(By.className("link-reservation")).getAttribute("href");
				HashMap<String,Object> map=new HashMap<>();
				map.put("title",title);
				map.put("image",image);
				map.put("link","http://www.cgv.co.kr/"+ link);
				
				if(!title.equals("")){
					map.put("no", no++);
					list.add(map);
					System.out.println(no+"."+title);
				}
			}
			driver.quit();
			}catch(Exception e){
			System.out.println("CGV_more 오류:"+e.toString());
		}
		return list;
		
	}
	
	
	
	
	@RequestMapping("/cgv")
	public List<HashMap<String,Object>> cgv(){
		List<HashMap<String,Object>> list =new ArrayList<HashMap<String,Object>>();
		try{
			Document doc=Jsoup.connect("http://www.cgv.co.kr/movies/?lt=1&ft=0").get();
			Elements elements=doc.select(".sect-movie-chart ol");
			for(Element e:elements.select("li")){
				String no=e.select(".rank").text();
					String image=e.select("img").attr("src");
					String title=e.select(".title").text();
					String link="http://www.cgv.co.kr"+e.select(".link-reservation").attr("href");
					System.out.println("...."+no+".........."+image+",.,,,"+link);
					HashMap<String,Object> map=new HashMap<>();
					map.put("no", no);
					map.put("title",title);
					map.put("link", link);
					map.put("image", image);
					if(!map.get("title").equals(""))
					list.add(map);
				
			}
			
		}catch(Exception e){
			System.out.println("CGV 오류:"+e.toString());
		}
		return list;
		
	}
}
