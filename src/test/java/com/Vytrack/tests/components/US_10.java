package com.Vytrack.tests.components;


import com.Vytrack.pages.LoginPage;
import com.Vytrack.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class US_10 extends TestBase {



    @Test
    public void test() throws InterruptedException {

        LoginPage loginPage=new LoginPage();
        loginPage.loginAsDriver();

        Thread.sleep(3000);

        WebElement fleet = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        Actions actions = new Actions(driver);

        actions.moveToElement(fleet).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Vehicles Fuel Logs']")).click();
        Thread.sleep(5000);

        int rowNumber = getNumberofRows();
        int colNumber = getNumberOfColumns();

        System.out.println("rowNumber = " + rowNumber);
        System.out.println("colNumber = " + colNumber);

        for (int i = 1; i <= rowNumber; i++) {
            for (int j = 1; j <= colNumber; j++) {

                String cellXpath = "//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr[" + i + "]/td[" + j + "]";
                System.out.println(cellXpath);

                WebElement cell = driver.findElement(By.xpath(cellXpath));
                System.out.println(cell.getText());


            }
        }
    }
        private int getNumberOfColumns () {
            List<WebElement> headers = driver.findElements(By.xpath("//thead[@class='grid-header']//th"));
            WebDriverWait wait=new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOfAllElements(headers));
            return headers.size();
        }

        private int getNumberofRows () {
            List<WebElement> allRows = driver.findElements(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr"));
            WebDriverWait wait=new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOfAllElements(allRows));
            return allRows.size();
        }
    }
