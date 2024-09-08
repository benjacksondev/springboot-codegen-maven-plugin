package com.benjacksondev.springbootcodegen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.benjacksondev.springbootcodegen.contentgenerators.ControllerGenerator;
import com.benjacksondev.springbootcodegen.contentgenerators.EntityGenerator;
import com.benjacksondev.springbootcodegen.contentgenerators.RepositoryGenerator;
import com.benjacksondev.springbootcodegen.contentgenerators.ServiceGenerator;

import au.com.origin.snapshots.Expect;
import au.com.origin.snapshots.junit5.SnapshotExtension;

@ExtendWith({SnapshotExtension.class})
class GeneratorSnapshotTests {

    private Expect expect;

    @Test
    void generateControllerTest() {
        ControllerGenerator controllerGenerator = new ControllerGenerator();
        controllerGenerator.setComponentName("Gorilla");
        controllerGenerator.setPackageName("com.example.animals");

        ContentGeneratorResult result = controllerGenerator.generate();

        assertEquals("GorillaController", result.getClassName());
        expect.toMatchSnapshot(result.getClassContent());
    }

    @Test
    void generateServiceTest() {
        ServiceGenerator serviceGenerator = new ServiceGenerator();
        serviceGenerator.setComponentName("Zebra");
        serviceGenerator.setPackageName("com.example.animals");

        ContentGeneratorResult result = serviceGenerator.generate();

        assertEquals("ZebraService", result.getClassName());
        expect.toMatchSnapshot(result.getClassContent());
    }

    @Test
    void generateRepositoryTest() {
        RepositoryGenerator repositoryGenerator = new RepositoryGenerator();
        repositoryGenerator.setComponentName("Hippo");
        repositoryGenerator.setPackageName("com.example.animals");

        ContentGeneratorResult result = repositoryGenerator.generate();

        assertEquals("HippoRepository", result.getClassName());
        expect.toMatchSnapshot(result.getClassContent());
    }

    @Test
    void generateEntityTest() {
        EntityGenerator entityGenerator = new EntityGenerator();
        entityGenerator.setComponentName("Giraffe");
        entityGenerator.setPackageName("com.example.animals");

        ContentGeneratorResult result = entityGenerator.generate();

        assertEquals("Giraffe", result.getClassName());
        expect.toMatchSnapshot(result.getClassContent());
    }
    
}
