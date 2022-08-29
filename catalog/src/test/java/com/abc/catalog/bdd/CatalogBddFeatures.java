/*
 * Copyright (c) 2022 Abc Co. All rights reserved.
 */

package com.abc.catalog.bdd;

import static io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.JUNIT_PLATFORM_NAMING_STRATEGY_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.ConfigurationParameters;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

/*
 CatalogBddFeatures.
 */

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameters({
    @ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,
        value = "json:build/cucumber/cucumber.json"),
    @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.abc.catalog.bdd"),
    @ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "not @Disabled"),
    @ConfigurationParameter(key = PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true"),
    @ConfigurationParameter(key = JUNIT_PLATFORM_NAMING_STRATEGY_PROPERTY_NAME, value = "long")
})
public class CatalogBddFeatures {

}
