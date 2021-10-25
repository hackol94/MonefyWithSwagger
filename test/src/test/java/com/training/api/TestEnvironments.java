package com.training.api;

import constans.Constant;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;

public class TestEnvironments {

    private final EnvironmentVariables testEnvironments;

    public TestEnvironments(EnvironmentVariables testEnvironments){
        this.testEnvironments = testEnvironments;
    }

    public String getContext (){
        return EnvironmentSpecificConfiguration.from(this.testEnvironments)
                .getProperty("context");
    }

    public String getUrlBase (){
        return EnvironmentSpecificConfiguration.from(this.testEnvironments)
                .getProperty(Constant.BASE_URL);
    }

    public String getPathInventory (){
        return EnvironmentSpecificConfiguration.from(this.testEnvironments)
                .getProperty(Constant.PATH_INVENTORY);
    }

    public String getPathOrder (){
        return EnvironmentSpecificConfiguration.from(this.testEnvironments)
                .getProperty(Constant.PATH_ORDER);
    }

}
