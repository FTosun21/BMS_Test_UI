package com.tour.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CreateYourVacationPage {
    private Page page;
    private final Locator close_btn;
    private final Locator createYourVacation_btn;
    private final Locator add_a_Flight_chckBx;
    private final Locator add_a_Car_chckBx;
    private final Locator ticketTypeDropDown;
    private final Locator ticketType;
    private final Locator returnDifferentPlace;
    private final Locator leavingFrom;
    private final Locator ownReturnCity;
    private final Locator please_enter_a_destination;
    private final Locator arriveingOn;
    private final Locator addDate;
    private final Locator departingOn;
    private final Locator addDestination;
    String date;




    public CreateYourVacationPage(Page page) {
        this.page = page;
        this.close_btn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Close"));
        this.createYourVacation_btn = page.locator("#own-vacations-tab");
        this.add_a_Flight_chckBx= page.getByLabel("Create your vacation")
                .locator("label")
                .filter(new Locator.FilterOptions().setHasText("Add a flight"))
                .locator("i");
        this.add_a_Car_chckBx= page.getByLabel("Create your vacation")
                .locator("label")
                .filter(new Locator.FilterOptions().setHasText("Add a car"))
                .locator("i");
        this.ticketTypeDropDown= page.locator("#ownTravelClass")
                .getByLabel("Select");
        this.ticketType=page.getByText("Economy", new Page.GetByTextOptions().setExact(true));
        this.returnDifferentPlace=page.locator("#flightSection i");
        this.leavingFrom=page.locator("#ownOriginCity").getByRole(AriaRole.COMBOBOX);
        this.ownReturnCity=page.locator("#ownReturnCity").getByRole(AriaRole.COMBOBOX);
        this.please_enter_a_destination= page.getByLabel("Create your vacation").getByRole(AriaRole.COMBOBOX);
        this.arriveingOn=page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Arriving On"));
        this.addDate =page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(date));
        this.departingOn=page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Departing On"));
        this.addDestination=page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("+ Add Destination"));


    }

    public Locator getClose_btn() {
        return close_btn;
    }

    public Locator getCreateYourVacationBtn(){
        return createYourVacation_btn;
    }
    public Locator getAdd_a_Flight_chckBx(){
        return add_a_Flight_chckBx;
    }
    public Locator getAdd_a_Car_chckBx(){
        return add_a_Car_chckBx;
    }
    public Locator getTicketType(){
        return ticketType;
    }
    public Locator getTicketTypeDropDown() {
        return ticketTypeDropDown;
    }

    public Locator getReturnDifferentPlace() {
        return returnDifferentPlace;
    }

    public Locator getLeavingFrom() {
        return leavingFrom;
    }

    public Locator getOwnReturnCity() {
        return ownReturnCity;
    }

    public Locator getPlease_enter_a_destination() {
        return please_enter_a_destination;
    }

    public Locator getArriveingOn() {
        return arriveingOn;
    }

    public Locator getAddDate(String date) {
        this.date=date;
        return addDate;
    }

    public Locator getDepartingOn() {
        return departingOn;
    }

    public Locator getAddDestination() {
        return addDestination;
    }
}
