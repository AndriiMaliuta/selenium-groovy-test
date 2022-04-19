package com.anma.tst.selenium_groovy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxBinary
import org.openqa.selenium.firefox.FirefoxDriver

class WikiTests {

    def url = "https://en.wikipedia.org/wiki/Example.com"

    private WebDriver driver

//    @BeforeAll
//    static void beforeAll() {
//
//    }

    @BeforeEach
    void setUp() {
        driver = new FirefoxDriver()
        driver.get(url)
    }

    @Test
    void testPage1() {
        Assertions.assertEquals("Firefox", driver.getTitle());
        driver.quit()
    }
}
