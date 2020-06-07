package br.com.jmw.commands.pkg;


import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "package"//,
//        subcommands = {
//           SearchCommand.class,
//        }
)
public class PackageCommand implements Callable<Integer> {
    @Override
    public Integer call(){
        System.out.println("The popular package command");
        return 0;
    }
}
