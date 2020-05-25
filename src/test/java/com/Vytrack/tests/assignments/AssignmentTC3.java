package com.Vytrack.tests.assignments;

import com.Vytrack.pages.CalendarEventsPage;
import com.Vytrack.pages.DashboardPage;
import com.Vytrack.pages.LoginPage;
import com.Vytrack.tests.TestBase;
import com.Vytrack.utilities.BrowserUtils;
import com.Vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssignmentTC3 extends TestBase {


    @Test
    public void TC_1() {

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        Assert.assertTrue(calendarEventsPage.Options.isDisplayed(), "verify Options is displayed");
    }


    @Test
    public void TC_2() {

        new LoginPage().loginAsStoreManager();

        new DashboardPage().navigateToModule("Activities", "Calendar Events");

        String expectedPageNumber = "1";
        String actualPageNumber = new CalendarEventsPage().pageNumber.getAttribute("value");

        Assert.assertEquals(actualPageNumber, expectedPageNumber, "verify page number");


    }

    @Test

    public void TC_3() {

        new LoginPage().loginAsStoreManager();

        new DashboardPage().navigateToModule("Activities", "Calendar Events");

        String expectedPerPageNumber = "25";
        String actualPerPageNumber = new CalendarEventsPage().perPageNumber.getText().trim();

        Assert.assertEquals(actualPerPageNumber, expectedPerPageNumber, "verify per page number");

    }

    @Test

    public void TC_4() {

        new LoginPage().loginAsStoreManager();

        new DashboardPage().navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(5);

        String[] arr = calendarEventsPage.numberOfRecords.getAttribute("innerHTML").split(" ");

        String totalRecords = arr[2];

        String pages = calendarEventsPage.totalPages.getAttribute("innerHTML");

        String []s=pages.split(" ");
        String totalPageNumber = (s[1].split("&")[0]);

        String actualPerPageNumber = new CalendarEventsPage().perPageNumber.getText().trim();

        calendarEventsPage.pageNumber.sendKeys(Keys.DELETE);
        calendarEventsPage.pageNumber.sendKeys(totalPageNumber);
        calendarEventsPage.pageNumber.sendKeys(Keys.ENTER);

        BrowserUtils.waitFor(3);

        int totalEvents = (Integer.parseInt(totalPageNumber) - 1) * Integer.parseInt(actualPerPageNumber) + calendarEventsPage.rowNumber;


        BrowserUtils.waitFor(3);

        System.out.println(calendarEventsPage.rowNumber);
        System.out.println(totalEvents);
        System.out.println(totalRecords);

        Assert.assertEquals(Integer.parseInt(totalRecords), totalEvents, "verify number of records and number of calendar events are equal");


    }


    @Test
    public void TC_5() {

        new LoginPage().loginAsStoreManager();

        new DashboardPage().navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        BrowserUtils.waitFor(3);
        calendarEventsPage.checkbox.click();


        Assert.assertTrue(calendarEventsPage.checkboxIndex.isSelected(), "Verify all calender events were selected");

        //Burada 10 yerine
        //String pages = calendarEventsPage.totalPages.getAttribute("innerHTML");
        //String []s=pages.split(" ");
        //String totalPageNumber = (s[1].split("&")[0]);
        //int totalPages=Integer.parseInt(totalPageNumber);

        for (int i = 1; i < 10; i++) {
            BrowserUtils.waitFor(2);

            calendarEventsPage.rightArrow.click();

            Assert.assertTrue(calendarEventsPage.checkboxIndex.isSelected(), "Verify all calender events were selected");
            BrowserUtils.waitFor(2);

        }
    }

        @Test
        public void TC_6() {

            new LoginPage().loginAsStoreManager();

            new DashboardPage().navigateToModule("Activities", "Calendar Events");

            CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

            calendarEventsPage.waitUntilLoaderScreenDisappear();
            BrowserUtils.waitFor(3);
            calendarEventsPage.filter.click();
            BrowserUtils.waitFor(3);
            calendarEventsPage.titlebox.click();

            calendarEventsPage.titleInputBox.sendKeys("Testers meeting");
            calendarEventsPage.titleInputBox.sendKeys(Keys.ENTER);

            BrowserUtils.waitFor(3);
            calendarEventsPage.firstRow.click();

            System.out.println(Driver.get().findElement(By.xpath("(//div[@class='control-group attribute-row'])[1]")).getText());


        }
    }
