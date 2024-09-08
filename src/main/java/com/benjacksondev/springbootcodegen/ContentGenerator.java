package com.benjacksondev.springbootcodegen;

public interface ContentGenerator {

    public ContentGeneratorResult generate();

    public void setComponentName(String component);

    public void setPackageName(String packageName);

}
