package br.com.jmw.command;

import picocli.CommandLine;

@CommandLine.Command(subcommands = {
   CommandLine.HelpCommand.class
})
public class JmwCommand implements Runnable {
    @Override
    public void run() {
        throw new IllegalArgumentException();
    }
}
