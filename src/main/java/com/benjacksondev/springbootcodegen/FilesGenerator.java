package com.benjacksondev.springbootcodegen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FilesGenerator {

    private String baseDir;

    public FilesGenerator(String baseDir) {
        this.baseDir = baseDir;
    }

    public void generate(ContentGeneratorResult contentGeneratorResult) throws IOException {
        // Create directory structure
        File dir = new File(baseDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Create the class file
        File classFile = new File(baseDir, contentGeneratorResult.getClassName() + ".java");
        if (!classFile.exists()) {
            classFile.createNewFile();
        }

        // Write service class content
        try (FileWriter writer = new FileWriter(classFile)) {
            writer.write(contentGeneratorResult.getClassContent());
        }
    }
}
