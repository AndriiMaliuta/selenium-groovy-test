package com.anma.tst.selenium_groovy

import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.firefox.FirefoxDriver

class SeleniumOldTest {

    private WebDriver driver;

    @BeforeAll
    public static void setUpDriver() {
        WebDriverManager.firefoxdriver().setup()
    }

    @BeforeEach
    void setUp() {
        driver = new FirefoxDriver()
    }

    @AfterEach
    void afterAll() {
        driver.quit()
    }

    @Test
    void openGoogle() {
        driver.get("https://google.com")
//        driver.wait(2000)
        def input = driver.findElement(By.tagName("input"))
        input.sendKeys("Selenium")
    }
}
