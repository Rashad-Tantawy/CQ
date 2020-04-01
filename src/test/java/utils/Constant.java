package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class Constant {

    private static WebDriver Driver;

    public static final String Path_TestData = "C://Users//RashadTantawy//IdeaProjects//cequens//";

    public static final String File_TestData = "TestData.xlsx";


    private static Select select;


    public static void selectByPartOfVisibleText(String value) throws InterruptedException {
        List<WebElement> optionElements = Driver.findElement(By.cssSelector("SELECT-SELECTOR")).findElements(By.tagName("option"));

        for (WebElement optionElement : optionElements) {
            if (optionElement.getText().contains(value)) {
                String optionIndex = optionElement.getAttribute("index");
                select.selectByIndex(Integer.parseInt(optionIndex));
                break;

            }
        }

        Thread.sleep(300);
    }

}