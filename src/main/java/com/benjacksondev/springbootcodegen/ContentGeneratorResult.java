package com.benjacksondev.springbootcodegen;

public class ContentGeneratorResult {

    private String className;
    private String classContent;

    public ContentGeneratorResult(String className, String classContent) {
        this.className = className;
        this.classContent = classContent;
    }

    public String getClassName() {
        return className;
    }

    public String getClassContent() {
        return classContent;
    }
}
