package com.anma.tst.selenium_groovy

import org.junit.jupiter.api.*
import static org.junit.jupiter.api.Assertions.*
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.interactions.Actions

import java.util.concurrent.TimeUnit

class MainPageTest {
    private WebDriver driver
    private MainPage mainPage

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver()
        driver.manage().window().maximize()
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
        driver.get("https://www.jetbrains.com/")

        mainPage = new MainPage(driver)
    }

    @AfterEach
    void tearDown() {
        driver.quit()
    }

    @Test
    void search() {
        mainPage.searchButton.click()

        WebElement searchField = driver.findElement(By.id("header-search"))
        searchField.sendKeys("Selenium")

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit' and text()='Search']"))
        submitButton.click()

        WebElement searchPageField = driver.findElement(By.className("js-search-input"))
        assertEquals("Selenium", searchPageField.getAttribute("value"))
    }

    @Test
    void toolsMenu() {
        new Actions(driver)
                .moveToElement(mainPage.toolsMenu)
                .perform()

        WebElement menuPopup = driver.findElement(By.className("menu-main__popup-wrapper"))
        assertTrue(menuPopup.isDisplayed())
    }

    @Test
    void navigationToAllTools() {
        mainPage.seeAllToolsButton.click()

        WebElement productsList = driver.findElement(By.className("products-list"))
        assertTrue(productsList.isDisplayed())
        assertEquals("All Developer Tools and Products by JetBrains", driver.getTitle())
    }
}
