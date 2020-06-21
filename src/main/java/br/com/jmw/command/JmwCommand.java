package br.com.jmw.command;

import br.com.jmw.command.search.SearchCommand;
import br.com.jmw.command.search.dtos.Dependency;
import com.fasterxml.jackson.databind.ObjectMapper;
import picocli.CommandLine;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@CommandLine.Command(name="jmw",subcommands = {
        CommandLine.HelpCommand.class
})
public class JmwCommand implements Runnable {
    @Override
    public void run() {
        throw new IllegalArgumentException();
    }
}
