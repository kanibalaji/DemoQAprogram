package org.seliniumoverload;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Demo {

	
	public static void main(String[] args)throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("kani");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("mozhi");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("kanibalaji16@gmail.com");
		WebElement female =driver.findElement(By.xpath("//label[contains(text(),'Female')]"));
		female.click();
		System.out.println(female.isSelected());
		driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys("8610913730");
		driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).click();
		//date of birth drop down
		WebElement dropdown=driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[5]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/select[1]"));
		WebElement dropdown1=driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[5]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/select[1]"));
		Select dd=new Select(dropdown);
		Select dd1=new Select(dropdown1);
		dd1.selectByVisibleText("December");
		dd.selectByVisibleText("1995");
		driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[5]")).click();
		//checklist
				WebElement Music=driver.findElement(By.xpath(" //label[contains(text(),'Music')]"));
				Music.click();
				WebElement Sports=driver.findElement(By.xpath("//label[contains(text(),'Sports')]"));
				Sports.click();
				//unclick
			    Sports.click();
			    //upload file
			    driver.findElement(By.xpath("//*[@id=\\\"uploadPicture\\\"]")).sendKeys("C:\\Users\\BALAJI S\\Desktop\\image");
			    driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("no.153/55,old mambalam road,saidapet,chennai-15");
			    //screenshot
			    File firstSrc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			    File dest=new File("./Snap/img.png");
				 FileUtils.copyFile(firstSrc, dest);
				 driver.quit();
				 
			    
			    
		
		
		

	}

}
