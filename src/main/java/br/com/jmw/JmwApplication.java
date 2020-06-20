package br.com.jmw;

import br.com.jmw.command.JmwCommand;
import br.com.jmw.command.QuarkusCommand;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.apache.maven.shared.utils.cli.CommandLineUtils;
import picocli.CommandLine;

import javax.inject.Inject;


@QuarkusMain
public class JmwApplication implements QuarkusApplication {
    @Inject
    private JmwCommand jmwCommand;

    @Override
    public int run(String... args) throws Exception {
        if(args.length == 0) {
            Quarkus.waitForExit();
            return 0;
        }
        if (args.length == 1) {
            args = CommandLineUtils.translateCommandline(args[0]);
        }
        return   new CommandLine(new QuarkusCommand())
                .addSubcommand(jmwCommand)
                .execute(args);
    }
}
