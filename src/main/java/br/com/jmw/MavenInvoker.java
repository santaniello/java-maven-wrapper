package br.com.jmw;

import org.apache.maven.shared.invoker.*;

import java.io.File;
import java.util.Collections;
import java.util.Properties;

public class MavenInvoker {

//    public static void main(String[] args) throws MavenInvocationException {
//        InvocationRequest request = new DefaultInvocationRequest();
//        request.setGoals( Collections.singletonList("archetype:generate") );
//        request.setBatchMode(true);
//        Properties properties = new Properties();
//        properties.setProperty("groupId", "com.maven");
//        properties.setProperty("artifactId", "test");
//        //properties.setProperty("archetypeVersion", "1.0-alpha-4");
//        //properties.setProperty("archetypeGroupId", "org.apache.maven.archetypes");
//        properties.setProperty("archetypeArtifactId", "maven-archetype-quickstart");
//        //properties.setProperty("archetypeCatalog", "http://repo1.maven.org/maven2/archetype-catalog.xml");
//        request.setProperties(properties);
//        Invoker invoker = new DefaultInvoker();
//        invoker.setMavenHome(new File(System.getenv("MAVEN_HOME")));
//        invoker.setWorkingDirectory(new File("/home/santaniello/teste"));
//        InvocationResult result = invoker.execute( request );
//        int exitCode = result.getExitCode();
//        System.out.println("Codigo" + exitCode);
//
//
//    }
}