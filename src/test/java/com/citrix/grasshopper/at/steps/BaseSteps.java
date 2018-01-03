package com.citrix.grasshopper.at.steps;

import PageObjects.GrasshopperApp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseSteps {

    public static GrasshopperApp app = null;

    public static final Logger logger = LogManager.getLogger("GrasshopperApp");
}
