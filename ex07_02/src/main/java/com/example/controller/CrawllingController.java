package com.example.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.DecimalFormat;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ShopDAO;
import com.example.domain.ShopVO;

@RestController
@RequestMapping("/api/crawl")
public class CrawllingController {
	@Autowired
	ShopDAO dao;
	
	@RequestMapping("/shop")
	public List<HashMap<String,Object>> shop(String query){
		List<HashMap<String,Object>> list=new ArrayList<>();
		try{
			System.setProperty("webdriver.chrome.driver", "c:/data/spring/chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.hanbit.co.kr/search/search_list.html?keyword=" + query);
		
			List<WebElement> es = driver.findElements(By.className("ser_bg"));
			System.out.println("사이즈:" + es.size());
			
			int code=1;
			for(WebElement e:es){
				String image=e.findElement(By.className("ser_transbox")).getAttribute("src");
				String title=e.findElement(By.className("ser_text_title")).getText();
				String price=e.findElement(By.className("ser_text_line")).getText();
				
				String strCode=(String.valueOf(code++));
				ShopVO vo=new ShopVO();
				vo.setTitle(title);
				vo.setCode(strCode);
				
				String strPrice =price.replaceAll(",", "");
				strPrice=strPrice.replaceAll("원", "");
				vo.setPrice(Double.parseDouble(strPrice));
				System.out.println("가격:" + vo.getPrice());
				
				/*
				//이미지 다운로드
				String path="c:/upload/shop/";
				int last=image.lastIndexOf("/");
				String fileName=image.substring(last+1);
				File file=new File(path + fileName);
				if(!file.exists()){ 
					URL url=new URL(image);
					InputStream in=url.openStream();
					OutputStream out=new FileOutputStream(path + fileName);
					FileCopyUtils.copy(in, out);
					vo.setImage("/upload/shop/" + fileName);
				}
				dao.insert(vo);
				*/
			}
		}catch(Exception e){
			System.out.println("weather 오류:" + e.toString());
		}
		return list;
	}
	
	@RequestMapping("/cgv/more")
	public List<HashMap<String,Object>> more(){
		List<HashMap<String,Object>> list=new ArrayList<>();
		try{
			System.setProperty("webdriver.chrome.driver", "c:/data/spring/chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("http://www.cgv.co.kr/movies/?lt=1&ft=0");
			WebElement more=driver.findElement(
					By.className("btn-more-fontbold"));
			more.click();
			
			//1초 기다리기
			Thread.sleep(1000);
			
			//스크롤 밑으로 내리기
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript(
					"window.scrollTo(0, document.body.scrollHeight)");
			
			List<WebElement> es=driver.findElements(
					By.cssSelector(".sect-movie-chart ol li"));
			System.out.println("사이즈:" + es.size());
			int no=0;
			for(WebElement e:es){
				String title=e.findElement(By.className("title")).getText();
				String image=e.findElement(By.tagName("img")).getAttribute("src");
				String link=e.findElement(By.className("link-reservation")).getAttribute("href");
				HashMap<String,Object> map=new HashMap<>();

				map.put("title", title);
				map.put("image", image);
				map.put("link", "http://www.cgv.co.kr"+link);
				
				if(!title.equals("")) {
					map.put("no", no++);
					list.add(map);
					System.out.println(no +":" + title);
				}
			}
			//driver.quit();
		}catch(Exception e){
			System.out.println("cgv more 오류:" + e.toString());
		}
		return list;
	}
	
	@RequestMapping("/weather")
	public List<HashMap<String,Object>> weather(){
		List<HashMap<String,Object>> list=new ArrayList<>();
		try{
			Document doc=Jsoup.connect("https://www.daum.net/").get();
			Elements es=doc.select(".list_weather li");
			System.out.println("사이즈:" + es.size());
			
		}catch(Exception e){
			System.out.println("weather 오류:" + e.toString());
		}
		return list;
	}
	
	@RequestMapping("/cgv")
	public List<HashMap<String,Object>> cgv(){
		List<HashMap<String,Object>> list=new ArrayList<>();
		try{
			Document doc=Jsoup.connect("http://www.cgv.co.kr/movies/?lt=1&ft=0").get();
			Elements es=doc.select(".sect-movie-chart ol li");
			for(Element e:es){
				String no=e.select(".rank").text();

				String image=e.select("img").attr("src");
				String title=e.select(".title").text();
				String link="http://www.cgv.co.kr"+e.select(".link-reservation").attr("href");
				System.out.println(no+"\n"+image+"\n"+title+"\n"+link);
				System.out.println("--------------------------------------");
				HashMap<String,Object> map=new HashMap<>();
				map.put("no", no);
				map.put("title", title);
				map.put("image", image);
				map.put("link", link);
				if(!map.get("title").equals(""))
					list.add(map);
			}
		}catch(Exception e){
			System.out.println("CGV오류:" + e.toString());
		}
		return list;
	}
}
