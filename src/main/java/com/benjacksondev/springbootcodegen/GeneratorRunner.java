package com.benjacksondev.springbootcodegen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeneratorRunner {

    private final FilesGenerator filesGenerator;

    private List<ContentGenerator> contentGenerators = new ArrayList<>();

    private final String component;

    private final String packageName;

    public GeneratorRunner(FilesGenerator filesGenerator, String packageName, String component) {
        this.filesGenerator = filesGenerator;
        this.packageName = packageName;
        this.component = component;
    }

    public GeneratorRunner addContentGenerator(ContentGenerator contentGenerator) {
        contentGenerator.setComponentName(component);
        contentGenerator.setPackageName(packageName);
        this.contentGenerators.add(contentGenerator);
        return this;
    }

    public void run() throws IOException {
        for (ContentGenerator contentGenerator : contentGenerators) {
            ContentGeneratorResult contentGeneratorResult = contentGenerator.generate();
            filesGenerator.generate(contentGeneratorResult);
        }
    }

}
