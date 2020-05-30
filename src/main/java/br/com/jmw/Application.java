package br.com.jmw;

import picocli.CommandLine;
import picocli.jansi.graalvm.AnsiConsole;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "jwt", mixinStandardHelpOptions = true,
        version = "jwt 4.0",
        description = "Prints the checksum (MD5 by default) of a file to STDOUT.")
public class Application implements Callable<Integer> {

    @CommandLine.Parameters(index = "0", description = "The file whose checksum to calculate.")
    private String parameter;

    @Override
    public Integer call() throws Exception {
        System.out.printf("Parameter = " + this.parameter);
        return 0;
    }

    public static void main(String... args) {
        int exitCode;
        try (AnsiConsole ansi = AnsiConsole.windowsInstall()) {
            exitCode = new CommandLine(new Application()).execute(args);
        }
        System.exit(exitCode);
    }
}
