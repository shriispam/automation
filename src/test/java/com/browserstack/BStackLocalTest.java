package com.browserstack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BStackLocalTest extends SeleniumTest {

    @Test
    
    public void test() throws Exception {
    	  
    	
    	
    	
    	  driver.get("https://www.flipkart.com");
          Thread.sleep(1000); // Wait for 5 seconds
    }
}
