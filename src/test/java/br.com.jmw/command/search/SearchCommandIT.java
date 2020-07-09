package br.com.jmw.command.search;

import br.com.jmw.NativeImageHelper;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
@Tag("native-image")
public class SearchCommandIT {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private static final String executable = "target/java-maven-wrapper-1.0-SNAPSHOT-runner";

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
    @Disabled
    public void should_print_dependency_in_console() throws IOException, InterruptedException {
        Process process = new ProcessBuilder(executable, "search","guice","-l","1").start();
        process.waitFor(3, TimeUnit.SECONDS);
        assertEquals(getTableDependencies(), NativeImageHelper.getStdOut(process));
    }

    private String getTableDependencies(){
        String out =   String.format("" +"+----------------------------+----------------------+------------+---------+----------------+%n" +
                                         "| id                         | groupId              | artifactId | version | date           |%n" +
                                         "+----------------------------+----------------------+------------+---------+----------------+%n" +
                                         "| com.codeborne.replay:guice | com.codeborne.replay | guice      | 1.7     | (jun 30, 2020) |%n" +
                                         "+----------------------------+----------------------+------------+---------+----------------+%n");
        return  out;
    }

}
