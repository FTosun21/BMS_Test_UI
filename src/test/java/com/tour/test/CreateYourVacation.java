package com.tour.test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitUntilState;
import com.tour.utils.ConfigurationReader;
import com.tour.utils.Hooks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateYourVacation extends Hooks {
    /*
        framework kurulumu başarılı,
        pozitif senaryo uygulandı,
        senaryo ve stepler çalışıyor,
        test tam manasıyla tamamlanmadı,
        stpler methodlarla yenilenecek,
        assertionlar eklenecek.
        muhtemel bug tespiti var.
     */
    String url= ConfigurationReader.get("url");
    @Test
    void t01_e2e_createYourVacation() {
        page.navigate(url, new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));
       // createYourVacationPage.getClose_btn().click();

        createYourVacationPage.getCreateYourVacationBtn().click();
        page.waitForTimeout(3000);
        Assertions.assertTrue(createYourVacationPage.getAdd_a_Flight_chckBx().isChecked());
        createYourVacationPage.getAdd_a_Flight_chckBx().click();
        page.waitForTimeout(1000);
        createYourVacationPage.getAdd_a_Flight_chckBx().click();
        Assertions.assertTrue(createYourVacationPage.getAdd_a_Flight_chckBx().isChecked());
        createYourVacationPage.getAdd_a_Car_chckBx().check();
        Assertions.assertTrue(createYourVacationPage.getAdd_a_Car_chckBx().isChecked());
        createYourVacationPage.getTicketTypeDropDown().click();
        createYourVacationPage.getTicketType().click();
        page.waitForTimeout(1000);
        createYourVacationPage.getLeavingFrom().fill("Berlin");
        createYourVacationPage.getLeavingFrom().press("Enter");
        page.getByText("Berlin").first().click();

        page.waitForTimeout(1000);
        createYourVacationPage.getReturnDifferentPlace().click();
        createYourVacationPage.getOwnReturnCity().fill("Istanbul");
        createYourVacationPage.getOwnReturnCity().press("Enter");
        page.getByRole(AriaRole.LISTBOX).getByText("Istanbul", new Locator.GetByTextOptions().setExact(true)).click();

        // Scroll down using the mouse wheel
        page.mouse().wheel(0, 300);

        createYourVacationPage.getPlease_enter_a_destination().nth(3).click();
        createYourVacationPage.getPlease_enter_a_destination().nth(3).fill("Antalya");
        page.getByText("Antalya (City) Mediterranean").click();

        page.waitForTimeout(2000);
        //tarihlerde bug olabilir
        createYourVacationPage.getArriveingOn().first().click();
        createYourVacationPage.getAddDate("19").first().click();
        createYourVacationPage.getDepartingOn().first().click();
        createYourVacationPage.getAddDate("23").nth(1).click();
        page.waitForTimeout(1000);
        createYourVacationPage.getAddDestination().click();
        createYourVacationPage.getPlease_enter_a_destination().nth(4).click();
        createYourVacationPage.getPlease_enter_a_destination().nth(4).fill("İzmir");
        createYourVacationPage.getPlease_enter_a_destination().nth(4).press("Enter");
        page.getByText("Izmir (City) Aegean Region").nth(1).click();

        page.waitForTimeout(1000);
        //tarihlerde bug olabilir
        createYourVacationPage.getArriveingOn().nth(1).click();
        createYourVacationPage.getAddDate("25").first().click();
        createYourVacationPage.getDepartingOn().nth(1).click();
        createYourVacationPage.getAddDate("27").nth(1).click();
        // bu kısım page sayfasına taşınacak
        page.locator("#text-box-travelerownVacationGuest").getByRole(AriaRole.TEXTBOX).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Accept")).click();
        page.locator("#text-box-travelerownVacationGuest").getByRole(AriaRole.TEXTBOX).click();
        page.locator("#traveller-container-sourceownVacationGuest #child-increase i").click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("DONE 1 room, 3 travelers")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start Building")).click();

        page.waitForTimeout(3000);


    }

}
