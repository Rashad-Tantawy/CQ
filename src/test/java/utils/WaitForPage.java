package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForPage {




        public static void waitForLoad(WebDriver Driver) {
                ExpectedCondition<Boolean> pageLoadCondition = new
                        ExpectedCondition<Boolean>() {
                            public Boolean apply(WebDriver driver) {
                                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                            }
                        };
                WebDriverWait wait = new WebDriverWait(Driver, 1000);
                wait.until(pageLoadCondition);
            }
        }


