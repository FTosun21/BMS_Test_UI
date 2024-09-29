package com.tour.utils;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class BrowserFactory {

    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext browserContext;

    public static Page initBrowser(String browserName, boolean headless) {

        closeResources();

        playwright = Playwright.create();

        BrowserType browserType;

        switch (browserName.toLowerCase()) {
            case "chrome":
            case "chromium":
                browserType = playwright.chromium();
                break;
            case "firefox":
                browserType = playwright.firefox();
                break;
            case "webkit":
                browserType = playwright.webkit();
                break;
            default:
                throw new IllegalArgumentException("Unsuported browser:" + browserName);

        }

        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(headless));

        browserContext = browser.newContext(new Browser.NewContextOptions()
                .setRecordVideoDir(Paths.get("src/test/resources/records")));

        Page page = browserContext.newPage();
        page.context().clearCookies();  // Tüm cookies ve sessionları siler
        page.context().clearPermissions();  // Tüm izinleri sıfırlar

        return page;
    }
    public static void closeResources() {
        if (browserContext != null) {
            browserContext.close();
            browserContext = null;
        }
        if (browser != null) {
            browser.close();
            browser = null;
        }
        if (playwright != null) {
            playwright.close();
            playwright = null;
        }
    }
}
