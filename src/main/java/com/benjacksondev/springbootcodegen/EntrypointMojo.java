package com.benjacksondev.springbootcodegen;

import java.io.IOException;
import java.util.List;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import com.benjacksondev.springbootcodegen.contentgenerators.ControllerGenerator;
import com.benjacksondev.springbootcodegen.contentgenerators.EntityGenerator;
import com.benjacksondev.springbootcodegen.contentgenerators.RepositoryGenerator;
import com.benjacksondev.springbootcodegen.contentgenerators.ServiceGenerator;

/**
 * Maven Mojo to generate component code.
 */
@Mojo(name = "generate")
public class EntrypointMojo extends AbstractMojo {

    // Maven project to get base directory
    @Parameter(defaultValue = "${project}", readonly = true)
    private MavenProject project;

    // The package to generate the components in
    @Parameter(property = "package", defaultValue = "com.example.default")
    private String packageName;

    // List of components to generate code for
    @Parameter(property = "component")
    private String component;

    // List of generators to include in code generation
    @Parameter(property = "includes")
    private List<String> includes;

    // List of generators to exclude from code generation
    @Parameter(property = "excludes")
    private List<String> excludes;

    // Base output directory
    @Parameter(defaultValue = "${project.build.sourceDirectory}")
    private String outputDirectory;

    @Override
    public void execute() throws MojoExecutionException {
        if (component == null || component.isEmpty()) {
            getLog().warn("No component specified for code generation.");
            return;
        }

        getLog().info("Generating code for components in package: " + packageName);

        // Create the base package directory
        String baseDir = outputDirectory + "/" + packageName.replace('.', '/');
        getLog().info("Base package directory: " + baseDir);

        try {
            GeneratorRunner generatorRunner = new GeneratorRunner(new FilesGenerator(baseDir), packageName, component);

            if (shouldInclude("repository")) {
                generatorRunner.addContentGenerator(new RepositoryGenerator());
            }

            if (shouldInclude("controller")) {
                generatorRunner.addContentGenerator(new ControllerGenerator());
            }

            if (shouldInclude("service")) {
                generatorRunner.addContentGenerator(new ServiceGenerator());
            }

            if (shouldInclude("entity")) {
                generatorRunner.addContentGenerator(new EntityGenerator());
            }

            generatorRunner.run();
        } catch (IOException e) {
            throw new MojoExecutionException("Error generating component: " + component, e);
        }
    }

    private boolean shouldInclude(String generatorName) {
        if (hasIncludes()) {
            // is string in includes
            if (includes.contains(generatorName)) {
                return true;
            }
            return false;
        }

        if (hasExcludes()) {
            if (!includes.contains(generatorName)) {
                return true;
            }
            return false;
        }

        return true;
    }

    private boolean hasIncludes() {
        return !includes.isEmpty();
    }

    private boolean hasExcludes() {
        return !excludes.isEmpty();
    }

}
