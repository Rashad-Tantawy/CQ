package services;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.Constant;
import utils.WaitForPage;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class Dashboard {
    public static final WebDriver Driver = new FirefoxDriver();

    public static void createCustomer(String userFirstName, String userLastName, String email, String password, String number, String address1, String address2, boolean cases) throws InterruptedException {

       try {

           Driver.get("https://www.phptravels.net/admin/accounts/customers/add");
            //Driver.findElement(By.cssSelector(".add_button > button:nth-child(1)")).click();
            Driver.findElement(By.cssSelector("div.col-md-6:nth-child(1) > div:nth-child(1) > input:nth-child(2)")).sendKeys(userFirstName);
            Driver.findElement(By.cssSelector("div.col-md-6:nth-child(2) > div:nth-child(1) > input:nth-child(2)")).sendKeys(userLastName);
            Driver.findElement(By.cssSelector("div.col-md-6:nth-child(3) > div:nth-child(1) > input:nth-child(2)")).sendKeys(email);
            Driver.findElement(By.cssSelector("div.col-md-6:nth-child(4) > div:nth-child(1) > input:nth-child(2)")).sendKeys(password);
            Driver.findElement(By.cssSelector("div.col-md-6:nth-child(5) > div:nth-child(1) > input:nth-child(2)")).sendKeys(String.valueOf(number));
           Driver.findElement(By.xpath("/html/body/div[3]/div/form/div[1]/div/div[2]/div/div[6]/div/div/a")).click();
            Driver.findElement(By.xpath("/html/body/div[6]/div/input")).sendKeys("Albania");
        Driver.findElement(By.xpath("/html/body/div[6]/div/input")).sendKeys(Keys.ENTER);
            Driver.findElement(By.cssSelector("div.col-md-6:nth-child(8) > div:nth-child(1) > input:nth-child(2)")).sendKeys(address1);
            Driver.findElement(By.cssSelector("div.col-md-6:nth-child(9) > div:nth-child(1) > input:nth-child(2)")).sendKeys(address2);

            Driver.findElement(By.cssSelector("button.btn:nth-child(4)")).click();
            Thread.sleep(1000);

            if (cases == true) {
                String Alert_label = Driver.findElement(By.xpath("html.gr__phptravels_net body.pace-done div.wrapper div#content div.panel.panel-default div.panel-body div.xcrud div.xcrud-container div.xcrud-ajax div.xcrud-list-container table.xcrud-list.table.table-striped.table-hover tbody tr.xcrud-row.xcrud-row-0 td")).getText();
                System.out.println(Alert_label);
                Assert.assertEquals("customer created", email, Alert_label);

            } else {
                String Alert_label = Driver.findElement(By.xpath("html.gr__phptravels_net body.pace-done div.wrapper div#content div.panel.panel-default div.panel-body div.xcrud div.xcrud-container div.xcrud-ajax div.xcrud-list-container table.xcrud-list.table.table-striped.table-hover tbody tr.xcrud-row.xcrud-row-0 td")).getText();
                System.out.println(Alert_label);
                Assert.assertEquals("fail customer creation fail", email, Alert_label);
            }

        } catch (Exception e) {

            throw (e);

        }
    }


    public static void removeCustomer() {


        Driver.findElement(By.cssSelector("")).click();
        Driver.findElement(By.cssSelector("")).click();
        Driver.findElement(By.cssSelector("")).click();
        Driver.findElement(By.cssSelector("")).click();

        String Alert_label = Driver.findElement(By.cssSelector("")).getText();
        System.out.println(Alert_label);
        Assert.assertEquals("", "", "");


    }

    public static void adminSignIn(String Email, String password, String Url, boolean cases) throws InterruptedException {

       try {

            Driver.get(Url);

            Driver.findElement(By.xpath("/html/body/div[2]/form[1]/div[1]/label[1]/input")).sendKeys(Email);
            Driver.findElement(By.xpath("/html/body/div[2]/form[1]/div[1]/label[2]/input")).sendKeys(password);

            Driver.findElement(By.xpath("/html/body/div[2]/form[1]/button")).click();
            WaitForPage.waitForLoad(Driver);


           if (cases == true) {
                String Alert_label = Driver.findElement(By.id(".mainHeader")).getText();
                System.out.println(Alert_label);
                Assert.assertEquals("logged in successfully", "VIEW DEMO", "VIEW DEMO");

            } else {
                String Alert_label = Driver.findElement(By.id(".mainHeader")).getText();
                System.out.println(Alert_label);
                Assert.assertEquals("Failed to login ", "Hi Admin!", Alert_label);
            }

        } catch (Exception e) {

            throw (e);

        }

        }
}