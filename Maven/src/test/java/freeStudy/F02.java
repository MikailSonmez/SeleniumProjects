package freeStudy;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.annotations.*;

public class F02 {
    // Pre-Conditions annotations starting with before
    @BeforeSuite
    public void setUp(){
        System.out.println("setup system property for chrome");
    }

    @BeforeClass
    public void launchBrowser(){
        System.out.println("launch chrome browser");
    }
    @BeforeTest
    public void login(){
        System.out.println("login method");
    }
    @BeforeMethod
    public void enterUrl(){
        System.out.println("enter url");
    }

    // test cases starting with @Test
    @Test
    public void googleTitleTest(){
        System.out.println("google title test");
    }
    /*
    @BeforeMethod
    @Test 1
    @AfterMethod
    @BeforeMethod
    @Test 2
    @AfterMethod
     */

    @Test
    public void searchTest(){
        System.out.println("search test");
    }

    //post conditions starting with @After
    @AfterMethod
    public void logOut(){
        System.out.println("logout from app");
    }

    @AfterTest
    public void deleteAllCookies(){
        System.out.println("deleteAllCookies");
    }
    @AfterClass
    public void closeBrowser(){
        System.out.println("close Browser");
    }
    @AfterSuite
    public void generateTestReport(){
        System.out.println("generateTestReport");
    }

}
