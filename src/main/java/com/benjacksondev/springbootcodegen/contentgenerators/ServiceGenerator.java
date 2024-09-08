package com.benjacksondev.springbootcodegen.contentgenerators;

import com.benjacksondev.springbootcodegen.AbstractContentGenerator;
import com.benjacksondev.springbootcodegen.ContentGeneratorResult;

public class ServiceGenerator extends AbstractContentGenerator {

    @Override
    public ContentGeneratorResult generate() {
        return new ContentGeneratorResult(getClassName(), getClassContent());
    }

    public String getClassName() {
        return componentName + "Service";
    }

    public String getClassContent() {
        String entityName = componentName;
        String repositoryName = componentName + "Repository";

        return "package " + packageName + ";\n\n"
                + "import java.util.ArrayList;\n"
                + "import java.util.List;\n"
                + "import org.springframework.beans.factory.annotation.Autowired;\n"
                + "import org.springframework.stereotype.Service;\n\n"
                + "@Service\n"
                + "public class " + componentName + "Service {\n\n"
                + "    @Autowired\n"
                + "    " + repositoryName + " " + entityName.toLowerCase() + "Repository;\n\n"
                + "    public " + entityName + " create" + entityName + "(" + entityName + " " + entityName.toLowerCase() + ") {\n"
                + "        return " + entityName.toLowerCase() + "Repository.save(" + entityName.toLowerCase() + ");\n"
                + "    }\n\n"
                + "    public List<" + entityName + "> get" + entityName + "s() {\n"
                + "        List<" + entityName + "> " + entityName.toLowerCase() + "List = new ArrayList<>();\n"
                + "        " + entityName.toLowerCase() + "Repository.findAll().forEach(" + entityName.toLowerCase() + "List::add);\n"
                + "        return " + entityName.toLowerCase() + "List;\n"
                + "    }\n"
                + "}\n";
    }

}
