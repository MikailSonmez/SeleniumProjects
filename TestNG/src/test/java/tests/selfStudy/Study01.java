package tests.selfStudy;

import org.testng.annotations.*;

public class Study01 {
    // Pre-Conditions annotations starting with before
    @BeforeSuite
    public void setUp(){
        System.out.println("setup system property for chrome");

    }
    @BeforeClass
    public void launchBrowser(){
        System.out.println("Before class");
    }
    @BeforeTest
    public void login(){
        System.out.println("Before test");
    }

    @BeforeMethod
    public void enterUrl(){
        System.out.println("before method");
    }


    // test cases starting with @Test
    @Test
    public void googleTitleTest(){
        System.out.println("TEST TEST TEST TEST");
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
        System.out.println("TEST TEST TEST");
    }

    //post conditions starting with @After
    @AfterMethod
    public void logOut(){
        System.out.println("AFTER METHOD");
    }
    @AfterTest
    public void deleteAllCookies(){
        System.out.println("AFTER TEST deleteAllCookies");
    }
    @AfterClass
    public void closeBrowser(){
        System.out.println("AFTER CLASS close Browser");
    }
    @AfterSuite
    public void generateTestReport(){
        System.out.println("AFTER SUIT generateTestReport");
    }
}
