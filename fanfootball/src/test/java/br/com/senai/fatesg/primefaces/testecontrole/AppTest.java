package br.com.senai.fatesg.primefaces.testecontrole;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.TestCase;

public class AppTest extends TestCase {

	@Test
	public void testMain() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\matheuscmpv\\Documents\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.gmail.com");

		driver.manage().window().maximize();

		driver.findElement(By.id("identifierId")).sendKeys("matheuscampos61@gmail.com");

		try {
			Thread.sleep(2000);

			driver.findElement(By.className("CwaK9")).click();

			Thread.sleep(2000);

			driver.findElement(By.name("password")).sendKeys("93806593ma");

			Thread.sleep(2000);

			driver.findElement(By.className("CwaK9")).click();

			Thread.sleep(8000);

			driver.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertEquals(driver.getCurrentUrl(), "https://mail.google.com/mail/u/0/");
		}
	}

}
