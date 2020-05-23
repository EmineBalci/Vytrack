package com.Vytrack.pages;

import com.Vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage(){

        PageFactory.initElements(Driver.get(), "this");
    }
        @FindBy(xpath = "//div[@class='btn-group actions-group']")

                public WebElement Options;

        @FindBy(xpath = "//input[@type='number']")

                public WebElement pageNumber;

        @FindBy(xpath = "(//div[@class='btn-group'])[2]")

                public  WebElement perPageNumber;

        @FindBy(xpath = "(//label[@class='dib'])[3]")

                public WebElement numberOfRecords;

        @FindBy(xpath = "(//label[@class='dib'])[2]")

                public WebElement totalPages;


        public int rowNumber = getNumberofRows();

        private int getNumberofRows() {
        List<WebElement> allRows=Driver.get().findElements(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr"));
        return allRows.size()-1;
    }

}
