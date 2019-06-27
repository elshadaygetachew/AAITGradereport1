/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaitportal;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;



public class Gradereport  {
    public static void main(String[] args)throws InterruptedException, IOException{
    System.setProperty("webdriver.chrome.driver", "C:\\Gecko\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://portal.aait.edu.et/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        System.out.println("Successfully opened the website localhost");


        driver.findElement(By.id("UserName")).sendKeys("ATR/9033/09");
        driver.findElement(By.id("Password")).sendKeys("8237");
        driver.findElement(By.className("btn-success")).click();
        driver.navigate().to("https://portal.aait.edu.et/Grade/GradeReport");
        String hh = driver.getCurrentUrl();
        driver.get(hh);
        System.out.println(driver.findElement(By.tagName("table")).getText());
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("Report.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print("");
 
            printWriter.append(driver.findElement(By.tagName("table")).getText());
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    
}
}