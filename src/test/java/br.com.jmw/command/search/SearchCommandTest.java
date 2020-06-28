package br.com.jmw.command.search;

import br.com.jmw.UnitTestCommon;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static br.com.jmw.template.MavenDependencyTemplate.getMavenDependency;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@QuarkusTest
public class SearchCommandTest extends UnitTestCommon {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @InjectMock
    private MavenService mavenService;

    @Inject
    private SearchCommand searchCommand;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void should_print_dependency_in_console() {
        Mockito.when(mavenService.search(any(),any())).thenReturn(Arrays.asList(getMavenDependency()));
        searchCommand.run();
        assertEquals(String.format(getTableDependency()), outContent.toString());
    }

    private String getTableDependency(){
        String out =   String.format("" +"+-----------------------------+-----------------------+------------+---------+----------------+%n"+
                                         "| id                          | groupId               | artifactId | version | date           |%n"+
                                         "+-----------------------------+-----------------------+------------+---------+----------------+%n"+
                                         "| com.tomtom.speedtools:guice | com.tomtom.speedtools | guice      | 3.2.21  | (Dec 31, 2014) |%n"+
                                         "+-----------------------------+-----------------------+------------+---------+----------------+%n");
    return  out;
    }

}
