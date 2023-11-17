package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Testbase {

	public static Properties props;
	public FileInputStream file;
	public static WebDriver driver;
    
	public Testbase() throws Throwable {

		props = new Properties();

		try {
			file = new FileInputStream("./src/main/java/com/configprop/configprop");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			props.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void Initialization() {

		String browsername = props.getProperty("browser");

		if (browsername.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\pc\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

			driver = new ChromeDriver();

		}

		else if (browsername.equalsIgnoreCase("Edge")) {

			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\pc\\Desktop\\selenium\\edgedriver_win64(1)\\msedgedriver.exe");

			driver = new EdgeDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.get(props.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

	}

}
