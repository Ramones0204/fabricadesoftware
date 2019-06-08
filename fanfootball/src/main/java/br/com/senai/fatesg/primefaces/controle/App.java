package br.com.senai.fatesg.primefaces.controle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maxwell\\Documents\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.gmail.com");

		driver.manage().window().maximize();

		driver.findElement(By.id("identifierId")).sendKeys("fanfootballads@gmail.com");

		Thread.sleep(2000);

		driver.findElement(By.className("CwaK9")).click();

		Thread.sleep(2000);

		driver.findElement(By.name("password")).sendKeys("futebol.10");

		Thread.sleep(2000);

		driver.findElement(By.className("CwaK9")).click();

		Thread.sleep(8000);

		driver.close();
	}
}
