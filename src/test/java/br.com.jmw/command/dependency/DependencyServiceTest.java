package br.com.jmw.command.dependency;

import br.com.jmw.UnitTestCommon;
import io.quarkus.test.junit.QuarkusTest;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

@QuarkusTest
public class DependencyServiceTest extends UnitTestCommon {

    private static String URL_POM_TEST = "/home/santaniello/Workspaces/workspace-estudo/java-maven-wrapper/src/test/resources/pom-test.xml";

    @Test
    public void should_update_pom() throws IOException, XmlPullParserException {
        Assertions.assertTrue(true);
        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model = reader.read(new FileInputStream(new File(URL_POM_TEST)));

        model.setGroupId( "TestGroupArtifactID" );
        model.setArtifactId("TestGroupArtifactName");
        model.setVersion("1.0.0");


        Writer writer = new FileWriter(URL_POM_TEST);
        List<Dependency> dependencyList = model.getDependencies();


        Dependency dep3 = new Dependency();
        dep3.setGroupId("lala");
        dep3.setArtifactId("jojo");
        dep3.setVersion("3.0.0");
        dependencyList.add(dep3);

//model.addDependency(dep);
        model.setDependencies(dependencyList);
        new MavenXpp3Writer().write(writer, model );
        writer.close();

    }

    @Test
    public void teste() throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec("mvn clean install -DmyAwsomeProperty=awsome");
        process.waitFor();

    }
}
