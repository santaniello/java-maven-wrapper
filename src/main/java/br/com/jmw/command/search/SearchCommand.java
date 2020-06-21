package br.com.jmw.command.search;


import picocli.CommandLine;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
@CommandLine.Command(name = "search", description = "Search a depedency in maven repository")
public class SearchCommand implements Runnable {

    @Inject
    private ExternalMavenService mavenService;

    @CommandLine.Option(names = {"-d", "--dependency"}, description = "Who will we greet?", defaultValue = "World")
    private String dependency;

    @Override
    public void run() {
       mavenService.search(dependency);
    }
}
