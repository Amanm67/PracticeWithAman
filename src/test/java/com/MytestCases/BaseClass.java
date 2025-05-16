package com.MytestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseClass {
	
	public WebDriver driver;
	@Test
	public void setUP() {
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		
		String expectedTitle ="OrangeHRMgdg";
		Assert.assertEquals(actualTitle, expectedTitle, "Title Mismatch");
		
		
		
		
		

	}
	
	@Test
	public void add() {
		System.out.println("Add user");
		
	}
	@Test
	public void add1() {
		System.out.println("Add user1");
		
	}
	

}
