package br.com.jmw.commands.pkg;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "search"
)
public class PackageSearchCommand implements Callable<Integer> {
    @Override
    public Integer call() {
        System.out.println("The popular search command");
        return 0;
    }
}
