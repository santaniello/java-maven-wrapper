package br.com.jmw.command;

import br.com.jmw.command.search.MavenService;
import picocli.CommandLine;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
@CommandLine.Command(name = "teste")
public class TesteCommand implements Runnable{

    @Inject
    private MavenService mavenService;

    @Override
    public void run() {
        System.out.println("hhhhhhhhhhhhhhhhhhhhh");
        //mavenService.searchDependency();
    }
}
