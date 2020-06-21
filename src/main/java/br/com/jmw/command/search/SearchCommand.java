package br.com.jmw.command.search;


import picocli.CommandLine;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
@CommandLine.Command(name = "search", description = "Greet World!")
public class SearchCommand implements Runnable {

    @Inject
    private ExternalMavenService mavenService;

    @Override
    public void run() {
        mavenService.searchDependency();
    }
}
