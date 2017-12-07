package com.citrix.grasshopper.at.steps;

import cucumber.api.java.en.Then;
import org.junit.Assert;

public class FavoritesSteps extends BaseSteps {

    @Then("^user is able to perform call from the Favorites screen$")
    public void userIsAbleToPerformCallFromTheFavoritesScreen() throws Throwable {
        app.favoritesPage().initializeFavorites();

        if (app.favoritesPage().getFavoritesMap().size() == 0){
            // add new favorite from available contacts
            app.favoritesPage().addNewFavorite();
            app.contactsPage().selectRandomContact();
            app.favoritesPage().initializeFavorites();
        }

        app.favoritesPage().callFavoite(app.favoritesPage().getRandomFavoite());

        Assert.assertTrue("Verify call from Favorites can be performed", app.wifiCallPage().isWifiCallPresent());

        app.wifiCallPage().endCall();
    }
}
