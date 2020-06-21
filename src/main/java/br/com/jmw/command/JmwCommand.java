package br.com.jmw.command;

import picocli.CommandLine;

@CommandLine.Command(name="jmw",subcommands = {
        CommandLine.HelpCommand.class
})
public class JmwCommand implements Runnable {
    @Override
    public void run() {
        throw new IllegalArgumentException();
    }
}
