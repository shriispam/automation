package com.browserstack;

import com.browserstack.SeleniumTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.WebDriver;

public class BStackDemoTest extends SeleniumTest {
    @Test
    public void addProductToCart() throws Exception {

        
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	  driver.get("https://www.flipkart.com");
          Thread.sleep(1000); // Wait for 5 seconds
          
          WebElement inputElement = driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']"));
         
          inputElement.sendKeys("Samsung Galaxy S10");
         
          Thread.sleep(1000); // Wait for 4 seconds
          
          inputElement.sendKeys(Keys.ENTER);

          // Click on "search product?" link
        
        
          Thread.sleep(1000); // Wait for 5 seconds
          
       // Find the link element by its full XPath
          WebElement linkElement = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[1]/div[1]/div/div[1]/div/div/section/div[3]/div/a"));

          // Click on the link element
          linkElement.click();
          
          Thread.sleep(1000); // Wait for 5 seconds
          
          //checking the samsung checkbox
          
          
          WebElement checkboxElement = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[3]/div[2]/div/div/div/label/div[1]"));
//          can also do with css selector but if doesnt load properly,it gives issue
//          WebElement checkboxElement = driver.findElement(By.cssSelector("#container > div > div._36fx1h._6t1WkM._3HqJxg > div._1YokD2._2GoDe3 > div._1YokD2._3Mn1Gg.col-2-12 > div > div:nth-child(1) > div > section:nth-child(4) > div._3FPh42 > div > div > div > label > div._24_Dny"));
          // Check the checkbox if it's not already checked
          if (!checkboxElement.isSelected()) {
              checkboxElement.click();
          } else {
              // Uncheck the checkbox
              checkboxElement.click();
          }
          Thread.sleep(1000); // Wait for 5 seconds 
          
          
          //checking the assured checkBox
          WebElement checkboxElement2 = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[1]/div[1]/div/div[1]/div/section[4]/label/div[1]"));
          // Check the checkbox if it's not already checked
          if (!checkboxElement2.isSelected()) {
              checkboxElement2.click();
          } else {
              // Uncheck the checkbox
              checkboxElement2.click();
          }
          Thread.sleep(1000); // Wait for 5 seconds 
          
          
          //sort high to low
           
          WebElement sortHtL=driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[2]/div[1]/div/div/div[3]/div[4]"));
          sortHtL.click();
          Thread.sleep(1000);
          
         // coming till the parent ,where every div is child (i mean items)
          
          WebElement parentOfALL= driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[2]"));
          
          //coz we cant directly iterate webelement ,so it should be object or any instant of java class like list
          Thread.sleep(8000);
          List<WebElement> childDivs = parentOfALL.findElements(By.xpath("./div"));
       

          for (int i = 1; i <25; i++) {
          	
          	WebElement childDiv = childDivs.get(i);
            
             
              // Extract product name
              WebElement productNameElement =  childDiv.findElement(By.xpath(".//div[@class='_4rR01T']"));
              String productName = productNameElement.getText();

//               Extract display price
              WebElement displayPriceElement = childDiv.findElement(By.xpath(".//div[@class='_30jeq3 _1_WHN1']"));
              String displayPrice = displayPriceElement.getText();
//
//              // Extract link to product details page
              WebElement detailsPageLinkElement = childDiv.findElement(By.xpath(".//a[@class='_1fQZEK']"));
              String detailsPageLink = detailsPageLinkElement.getAttribute("href");
//
//              // Print product details
              System.out.println(i +") Product Name: " + productName);
              System.out.println("Prize: "+displayPrice); 
              System.out.println("Link to Product Details Page: " + detailsPageLink);
              System.out.println();
              

          }
          
          
          
    }
}
