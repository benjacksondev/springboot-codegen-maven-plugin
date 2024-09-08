package com.benjacksondev.springbootcodegen.contentgenerators;

import com.benjacksondev.springbootcodegen.AbstractContentGenerator;
import com.benjacksondev.springbootcodegen.ContentGeneratorResult;

public class EntityGenerator extends AbstractContentGenerator {
    
    @Override
    public ContentGeneratorResult generate() {
        return new ContentGeneratorResult(getClassName(), getClassContent());
    }
    
    private String getClassName() {
        return componentName;
    }

    private String getClassContent() {
        return "package " + packageName + ";\n\n"
                + "import jakarta.persistence.Entity;\n"
                + "import jakarta.persistence.GeneratedValue;\n"
                + "import jakarta.persistence.GenerationType;\n"
                + "import jakarta.persistence.Id;\n\n"
                + "@Entity\n"
                + "public class " + componentName + " {\n\n"
                + "    @Id\n"
                + "    @GeneratedValue(strategy = GenerationType.IDENTITY)\n"
                + "    private Long id;\n\n"
                + "    public " + componentName + "() {\n"
                + "    }\n\n"
                + "    public Long getId() {\n"
                + "        return id;\n"
                + "    }\n"
                + "}\n";
    }

}
