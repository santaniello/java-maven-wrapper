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
    public void should_print_dependency_in_console() throws IOException, InterruptedException {
        String exected = String.format("" +
                "Usage: <main class> search [-hV] [-l=<limit>] <dependencyName>%n" +
                "Search a depedency in maven repository%n" +
                "      <dependencyName>   Dependency's name%n" +
                "  -h, --help             Show this help message and exit.%n" +
                "  -l, --limit=<limit>    Quantity of dependencies to show%n" +
                "  -V, --version          Print version information and exit.%n");
        Process process = new ProcessBuilder(executable, "search","-h").start();
        process.waitFor(3, TimeUnit.SECONDS);
        assertEquals(exected, NativeImageHelper.getStdOut(process));
    }

    @Test
    public void should_print_search_command_version() throws IOException, InterruptedException {
        String exected = String.format("" +"search command - 1.0.0%n");
        Process process = new ProcessBuilder(executable, "search","--version").start();
        process.waitFor(3, TimeUnit.SECONDS);
        assertEquals(exected, NativeImageHelper.getStdOut(process));
    }

    @Test
    public void should_print_message_error_in_console_when_dependency_is_not_found() throws IOException, InterruptedException {
        String exected = String.format("" +"search command - 1.0.0%n");
        Process process = new ProcessBuilder(executable, "search","--version").start();
        process.waitFor(3, TimeUnit.SECONDS);
        assertEquals(exected, NativeImageHelper.getStdOut(process));
    }
}
