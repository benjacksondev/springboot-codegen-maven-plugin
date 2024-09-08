package com.benjacksondev.springbootcodegen.contentgenerators;

import com.benjacksondev.springbootcodegen.AbstractContentGenerator;
import com.benjacksondev.springbootcodegen.ContentGeneratorResult;
import com.benjacksondev.springbootcodegen.StringExtensions;

public class ControllerGenerator extends AbstractContentGenerator {

    @Override
    public ContentGeneratorResult generate() {
        return new ContentGeneratorResult(getClassName(), getClassContent());
    }

    private String getClassName() {
        return componentName + "Controller";
    }

    private String getClassContent() {
        String serviceName = componentName + "Service";
        String entityName = componentName;

        return "package " + packageName + ";\n\n"
                + "import java.util.List;\n"
                + "import org.springframework.beans.factory.annotation.Autowired;\n"
                + "import org.springframework.stereotype.Controller;\n"
                + "import org.springframework.ui.Model;\n"
                + "import org.springframework.validation.BindingResult;\n"
                + "import org.springframework.web.bind.annotation.GetMapping;\n"
                + "import org.springframework.web.bind.annotation.PostMapping;\n"
                + "import org.springframework.web.bind.annotation.RequestMapping;\n"
                + "import org.springframework.web.bind.annotation.RequestParam;\n"
                + "import jakarta.validation.Valid;\n\n"
                + "@Controller\n"
                + "@RequestMapping(\"/" + entityName.toLowerCase() + "\")\n"
                + "public class " + componentName + "Controller {\n\n"
                + "    @Autowired\n"
                + "    " + serviceName + " " + StringExtensions.studlyCapsToCamelCase(componentName) + ";\n\n"
                + "    @GetMapping(\"\")\n"
                + "    public String showAll(@RequestParam(required = false) String message, Model model) {\n"
                + "        List<" + entityName + "> " + StringExtensions.studlyCapsToCamelCase(entityName) + "s = " + StringExtensions.studlyCapsToCamelCase(entityName) + ".get" + entityName + "s();\n"
                + "        model.addAttribute(\"" + entityName.toLowerCase() + "s\", " + StringExtensions.studlyCapsToCamelCase(entityName) + "s);\n\n"
                + "        return \"" + entityName.toLowerCase() + "/index\";\n"
                + "    }\n\n"
                + "    @PostMapping(\"/create\")\n"
                + "    public String create(@Valid " + entityName + " " + StringExtensions.studlyCapsToCamelCase(entityName) + ", BindingResult result, Model model) {\n"
                + "        if (result.hasErrors()) {\n"
                + "            return \"redirect:/" + entityName.toLowerCase() + "/add\";\n"
                + "        }\n\n"
                + "        " + serviceName.toLowerCase() + ".create" + entityName + "(" + entityName.toLowerCase() + ");\n"
                + "        model.addAttribute(\"message\", \"some message\");\n"
                + "        return \"redirect:/" + entityName.toLowerCase() + "\";\n"
                + "    }\n"
                + "}\n";
    }

}
