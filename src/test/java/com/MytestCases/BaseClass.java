package com.MytestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClass {
	
	public  WebDriver driver;
	@Test(priority=2)
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
	
		@Test(enabled=true, description ="Login test cases is passed",priority =1)
		public void loginwithInvalidcredentials() {
			driver= new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
					
			driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
			driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin1234");
			driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
			
            String expectedtext="Invalid credentials";
            String actualtext=driver.findElement(By.xpath("//p[text()='Invalid credentials']")).getText();
            System.out.println(actualtext);
            Assert.assertEquals(expectedtext, actualtext);
			driver.close();
			
			
			
			
			
			
		}

}
