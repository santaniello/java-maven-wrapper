package br.com.jmw;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

public class UnitTestCommon {

    public String getFileFromResourcesAsString(String path) {
        try {
            return new String(Files.readAllBytes(getFileFromResources(path).toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Não foi possível encontrar o Payload !");
    }

    public  File getFileFromResources(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }
    }
}
