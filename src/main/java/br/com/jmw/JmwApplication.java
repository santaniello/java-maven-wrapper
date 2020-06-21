package br.com.jmw;

import br.com.jmw.command.JmwCommand;
import br.com.jmw.command.TesteCommand;
import br.com.jmw.command.search.SearchCommand;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.apache.maven.shared.utils.cli.CommandLineUtils;
import picocli.CommandLine;

import javax.inject.Inject;


@QuarkusMain
public class JmwApplication implements QuarkusApplication {
    @Inject
    private SearchCommand searchCommand;
    @Inject
    private TesteCommand testeCommand;

    @Override
    public int run(String... args) throws Exception {
        if(args.length == 0) {
            Quarkus.waitForExit();
            return 0;
        }
        if (args.length == 1) {
            args = CommandLineUtils.translateCommandline(args[0]);
        }

//        CommandLine searchCommandLine = new CommandLine(searchCommand)
//                                        .addSubcommand(testeCommand);

        return new CommandLine(new JmwCommand())
                .addSubcommand(searchCommand)
                .execute(args);
    }
}
