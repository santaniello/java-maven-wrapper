package br.com.jmw.command;

import picocli.CommandLine;

import javax.enterprise.context.Dependent;

@Dependent
@CommandLine.Command(name = "jmw", mixinStandardHelpOptions = true, description = "Greet person by their name")
public class JmwCommand implements Runnable {

    @Override
    public void run() {
        System.out.println("sdjnsdnsnsndunsudnusnd");
    }
}
