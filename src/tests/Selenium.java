package tests;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium {
	
	public static void main(String[] args) throws InterruptedException {
		
		// Telling to system to use chrome driver at the given path when trying to launch a browser
		System.setProperty("webdriver.chrome.driver", "/Users/cybertekchicago-1/Desktop/seleniumDependecy/drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://cybertek-bnb.herokuapp.com");
		
		String title = driver.getTitle();
		String url = driver.getCurrentUrl();
		System.out.println("Title: " + title);
		System.out.println("Url: " + url);
		if(title.equals("Intro | cybertek-bnb")) {
			System.out.println("Title verification passed");
		}
		else {
			System.out.println("Title verification failed");
		}
		
		Random random = new Random();
		int r = random.nextInt(100000);
		String firstName = "John";
		String lastName = "Wick";
		String email = "jwi" + r + "@yahoo.com";
		String password = "JW2018";
		System.out.println("Email: " + email);
		
		WebElement signUpBtn = driver.findElement(By.linkText("sign up"));
		signUpBtn.click();
//		
		
		WebElement fName = driver.findElement(By.name("first-name"));
		WebElement lName = driver.findElement(By.name("last-name"));
		WebElement eMail = driver.findElement(By.name("email"));
		WebElement passwordEl = driver.findElement(By.name("password"));
		WebElement signUp = driver.findElement(By.xpath("//button[.='sign up']"));
		
		fName.sendKeys(firstName);
		lName.sendKeys(lastName);
		eMail.sendKeys(email);
		passwordEl.sendKeys(password);
		signUp.click();
		
		if(driver.getTitle().equals("Sing in | cybertek-bnb")) {
			System.out.println("Sign up successfully");
		}
		else {
			System.out.println("Sign up failed");
		}
		
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[.='sign in']")).click();
		
		String loggedInTitle = driver.getTitle();
		if(loggedInTitle.equals("Map | cybertek-bnb")) {
			System.out.println("User signed - in successfully");
		}
		else {
			System.out.println("User signed - in failed");
		}
		
		
//		driver.quit();
	}

}
