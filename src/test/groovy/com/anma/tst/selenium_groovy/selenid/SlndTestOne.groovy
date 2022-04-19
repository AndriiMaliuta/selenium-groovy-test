package com.anma.tst.selenium_groovy.selenid

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test

import static com.codeborne.selenide.Browsers.CHROME
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class SlndTestOne {

    @BeforeAll
    static void beforeAll() {
//        Configuration.browser = "https://en.wikipedia.org/wiki/Example.com"
//        System.getProperty("selenide.browser", CHROME);
    }

    @Test
    void todoOne() {
        def url = "https://www.selenium.dev/documentation/webdriver/getting_started/install_drivers/"
        Selenide.open(url)
        $(".infobox .vcard").selectOption(0)
        $(withText("Assigned")).shouldBe(Condition.visible)
        SelenideElement element1 = $(".aaa")

    }
}
