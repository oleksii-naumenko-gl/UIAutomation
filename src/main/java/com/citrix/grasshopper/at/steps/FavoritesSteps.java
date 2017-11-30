package com.citrix.grasshopper.at.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

public class FavoritesSteps extends BaseSteps {

    @Then("^user is able to perform call from the Favorites screen$")
    public void userIsAbleToPerformCallFromTheFavoritesScreen() throws Throwable {
        if (app.favoritesPage().getFavoriteContacts() == null){
            // add new favorite from available contacts


        }


    }
}
