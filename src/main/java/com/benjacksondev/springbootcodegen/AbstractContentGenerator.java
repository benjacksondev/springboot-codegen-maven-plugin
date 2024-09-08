package com.benjacksondev.springbootcodegen;

abstract public class AbstractContentGenerator implements ContentGenerator {

    protected String componentName;
    protected String packageName;

    public void setComponentName(String component) {
        this.componentName = component;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
