package com.Vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoadingWaits {

    public static void expWait(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement loader= driver.findElement(By.cssSelector(".loader-mask>.loader-frame"));
        wait.until(ExpectedConditions.invisibilityOfAllElements(loader));
    }

}
