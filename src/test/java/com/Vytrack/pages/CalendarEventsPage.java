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

        @FindBy(xpath = "//button/input[@type='checkbox']")

                public WebElement checkbox;

        @FindBy(xpath = "//input[@tabindex='-1']")

                public WebElement checkboxIndex;

        @FindBy(css = ".fa-chevron-right.hide-text")

                public WebElement rightArrow;

        @FindBy(css = ".fa-filter.hide-text")

                public WebElement filter;

        @FindBy(css = ".filter-criteria-hint")

                public WebElement titlebox;

        @FindBy(xpath = "//div/input[@type='text']")

                public WebElement titleInputBox;

        @FindBy(css = ".string-cell.grid-cell.grid-body-cell.grid-body-cell-title")

                public WebElement firstRow;




        public int rowNumber = getNumberofRows();

        private int getNumberofRows() {
        List<WebElement> allRows=Driver.get().findElements(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr"));
        return allRows.size()-1;
    }

        public void dropdownOptions() {
        List<WebElement> options=Driver.get().findElements(By.cssSelector(".dropdown-menu.dropdown-menu__select-all-header-cell"));

        options.get(0).click();

    }


}
