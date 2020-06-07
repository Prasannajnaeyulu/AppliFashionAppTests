package com.common.util;

public enum BrowserType {
    CHROME("chrome"),
    FIREFOX("firefox"),
    CHROMIUM_EDGE("edge");
    String browser;

    BrowserType(String browserName){
        this.browser = browserName;
    }

    @Override
    public String toString() {
        return this.browser;
    }

    public static BrowserType fromString(String browser) throws Exception {
        for(BrowserType browserType: values()){
            if(browserType.toString().equalsIgnoreCase(browser))
                return browserType;
        }
        throw new Exception("No broswer with the name '"+ browser+"' exist");
    }
}
