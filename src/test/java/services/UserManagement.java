package services;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.net.Urls;
import org.openqa.selenium.support.ui.Select;
import utils.WaitForPage;

import java.util.concurrent.TimeUnit;

public class UserManagement {

    public static final WebDriver Driver = new FirefoxDriver();


    public static void signUp(String userFirstName, String userLastName, String number,String email , String password, String confirmPassword, boolean cases) throws InterruptedException {

     try {

            Driver.get("https://www.phptravels.net/home");
            Driver.manage().window().maximize();
            Driver.findElement(By.cssSelector(".dropdown-login > a:nth-child(1)")).click();
            Driver.findElement(By.cssSelector("a.tr:nth-child(2)")).click();

            Driver.findElement(By.cssSelector("div.row:nth-child(3) > div:nth-child(1) > div:nth-child(1) > label:nth-child(1) > input:nth-child(1)")).sendKeys(userFirstName);
            Driver.findElement(By.cssSelector("div.row:nth-child(3) > div:nth-child(2) > div:nth-child(1) > label:nth-child(1) > input:nth-child(1)")).sendKeys(userLastName);
            Driver.findElement(By.cssSelector("div.form-group:nth-child(4) > label:nth-child(1) > input:nth-child(1)")).sendKeys(String.valueOf(number));
            Driver.findElement(By.cssSelector("div.form-group:nth-child(5) > label:nth-child(1) > input:nth-child(1)")).sendKeys(email);
            Driver.findElement(By.cssSelector("div.form-group:nth-child(6) > label:nth-child(1) > input:nth-child(1)")).sendKeys(password);
            Driver.findElement(By.cssSelector("div.form-group:nth-child(7) > label:nth-child(1) > input:nth-child(1)")).sendKeys(confirmPassword);

            Driver.findElement(By.xpath("/html/body/div[2]/div[1]/section/div/div/div[2]/div/form/div[8]/button")).click();
            Thread.sleep(1000);

           if (cases == true) {
                String Alert_label = Driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div/div/div[1]/div/div[2]/h3")).getText();
                System.out.println(Alert_label);
                String Check= "Hi,"+" "+userFirstName+" "+userLastName;
                Assert.assertEquals("User Created successfully", Check, Alert_label);

            } else {
                String Alert_label = Driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div/div/div[1]/div/div[2]/h3")).getText();
                System.out.println(Alert_label);
                String Check= "Hi,"+" "+userFirstName+" "+userLastName;
                Assert.assertEquals("Retry again", Check, Alert_label);
            }

        } catch (Exception e) {

            throw (e);

        }
    }
    public static void UsersSignIn(String Email, String password,String Url,boolean cases) throws InterruptedException {

       try {

        Driver.get(Url);

        Driver.findElement(By.xpath("/html/body/div[2]/div[1]/section/div/div[1]/div[2]/form/div[3]/div[1]/label/input")).sendKeys(Email);
        Driver.findElement(By.xpath("/html/body/div[2]/div[1]/section/div/div[1]/div[2]/form/div[3]/div[2]/label/input")).sendKeys(password);

        Driver.findElement(By.xpath("/html/body/div[2]/div[1]/section/div/div[1]/div[2]/form/button")).click();

            WaitForPage.waitForLoad(Driver);
           if (cases == true) {
                String Alert_label = Driver.findElement(By.cssSelector("/html/body/div[2]/div[1]/div[1]/div/div/div[1]/div/div[2]/h3")).getText();
                System.out.println(Alert_label);
                Assert.assertEquals("logged in successfully", "VIEW DEMO", "VIEW DEMO");

            } else {
                String Alert_label = Driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div/div/div[1]/div/div[2]/h3")).getText();
                System.out.println(Alert_label);
                Assert.assertEquals("Failed to login ", "DASHBOARD", Alert_label);
            }

        } catch (Exception e) {

            throw (e);

        }

    }



}