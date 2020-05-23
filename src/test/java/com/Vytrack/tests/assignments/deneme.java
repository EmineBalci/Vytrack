package com.Vytrack.tests.assignments;

import com.Vytrack.pages.CalendarEventsPage;
import com.Vytrack.pages.DashboardPage;
import com.Vytrack.pages.LoginPage;
import com.Vytrack.tests.TestBase;
import com.Vytrack.utilities.BrowserUtils;

public class deneme extends TestBase {
    public static void main(String[] args) {
        new LoginPage().loginAsStoreManager();

        new DashboardPage().navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(5);


    }
}