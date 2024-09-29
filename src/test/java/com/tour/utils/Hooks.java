package com.tour.utils;

import com.microsoft.playwright.Page;
import com.tour.pages.CreateYourVacationPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;


public class Hooks {

    protected static BrowserFactory browserFactory;
    protected static Page page;
    protected static CreateYourVacationPage createYourVacationPage;


    @BeforeAll
    public static void init() {
        String browserFromConfig = ConfigurationReader.get("browser");
        boolean isHeadless = Boolean.parseBoolean(ConfigurationReader.get("headless"));

        browserFactory = new BrowserFactory();
        page = browserFactory.initBrowser(browserFromConfig, isHeadless);

        createYourVacationPage=new CreateYourVacationPage(page);
    }

    @AfterAll
    public static void tearDown() {
        browserFactory.closeResources();
    }
}