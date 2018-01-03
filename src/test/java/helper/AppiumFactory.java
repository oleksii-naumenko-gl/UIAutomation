package helper;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class AppiumFactory {

    public static final Logger log = LogManager.getLogger(AppiumFactory.class);

    private static AppiumDriverLocalService service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
            .withStartUpTimeOut(5000, TimeUnit.SECONDS)
            .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
            .withArgument(GeneralServerFlag.LOG_LEVEL, "error"));

    public static AppiumDriverLocalService getService() {
        return service;
    }

    public static void startAppium() {
        log.info("-----------------START APPIUM-----------------------------");
        service.start();
        if (service.isRunning())
            log.info("-----------------APPIUM STARTED---------------------------");
    }

    public static void stopAppium() {
        log.info("----------------- APPIUM STOPPED -----------------------------");
        service.stop();
    }
}