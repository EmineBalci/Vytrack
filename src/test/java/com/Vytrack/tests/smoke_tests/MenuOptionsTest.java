package com.Vytrack.tests.smoke_tests;

import com.Vytrack.pages.LoginPage;
import com.Vytrack.tests.TestBase;
import org.testng.annotations.Test;

public class MenuOptionsTest extends TestBase {

  @Test (description = "Menu options, driver")

    public void test1_driver(){
    LoginPage loginPage=new LoginPage();

    loginPage.loginAsDriver();

  }
}
