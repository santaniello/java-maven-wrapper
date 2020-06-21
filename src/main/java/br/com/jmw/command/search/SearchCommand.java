package br.com.jmw.command.search;


import br.com.jmw.command.search.dtos.MavenDependency;
import picocli.CommandLine;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
@CommandLine.Command(name = "search", description = "Search a depedency in maven repository")
public class SearchCommand implements Runnable {

    @Inject
    private ExternalMavenService mavenService;

    @CommandLine.Option(names = {"-d", "--dependency"}, description = "Who will we greet?")
    private String name;

    @CommandLine.Option(names = {"-l", "--limit"}, description = "Who will we greet?", defaultValue = "2")
    private String limit;

    @Override
    public void run() {
        MavenDependency dependency = mavenService.search(name, limit);
    }
}
