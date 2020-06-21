package br.com.jmw.command.search;


import br.com.jmw.command.search.dto.MavenResponseDTO;
import picocli.CommandLine;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
@CommandLine.Command(name = "search", description = "Search a depedency in maven repository")
public class SearchCommand implements Runnable {

    @Inject
    private ExternalMavenService mavenService;

    @CommandLine.Option(names = {"-d", "--dependency"}, description = "Dependency's name")
    private String name;

    @CommandLine.Option(names = {"-l", "--limit"}, description = "Quantity of dependencies to show", defaultValue = "2")
    private String limit;

    @Override
    public void run() {
        MavenResponseDTO dependency = mavenService.search(name, limit);
    }
}
