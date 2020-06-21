package br.com.jmw.command.search;


import picocli.CommandLine;

@CommandLine.Command(name = "search", description = "Greet World!")
public class SearchCommand implements Runnable {

    @Override
    public void run() {
        System.out.println("Rodando Search");
    }
}
