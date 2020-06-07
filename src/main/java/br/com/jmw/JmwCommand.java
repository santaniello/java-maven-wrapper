package br.com.jmw;

import br.com.jmw.commands.search.SearchCommand;
import br.com.jmw.commands.pkg.PackageCommand;
import picocli.CommandLine;
import picocli.jansi.graalvm.AnsiConsole;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "jwt", mixinStandardHelpOptions = true,
        version = "jwt 1.0",
        description = "Prints the checksum (MD5 by default) of a file to STDOUT.",
        subcommands = {
             PackageCommand.class,
             SearchCommand.class
        }
)
public class JmwCommand  implements Callable<Integer> {

    public static void main(String[] args) {
        int exitCode;
        try (AnsiConsole ansi = AnsiConsole.windowsInstall()) {
            exitCode = new CommandLine(new JmwCommand()).execute(args);
        }
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {
        throw new IllegalArgumentException();
    }
}
