package com.benjacksondev.springbootcodegen.contentgenerators;

import com.benjacksondev.springbootcodegen.AbstractContentGenerator;
import com.benjacksondev.springbootcodegen.ContentGeneratorResult;

public class RepositoryGenerator extends AbstractContentGenerator {

    @Override
    public ContentGeneratorResult generate() {
        return new ContentGeneratorResult(getClassName(), getClassContent());
    }

    private String getClassName() {
        return componentName + "Repository";
    }

    private String getClassContent() {
        String entityName = componentName;

        return "package " + packageName + ";\n\n"
                + "import org.springframework.data.repository.CrudRepository;\n\n"
                + "public interface " + componentName + "Repository extends CrudRepository<" + entityName + ", Long> {\n"
                + "}\n";
    }
}
