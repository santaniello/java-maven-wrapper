package br.com.jmw.command.search;


import br.com.jmw.command.search.dto.MavenResponseDTO;
import br.com.jmw.menu.CommandLineTable;
import br.com.jmw.model.MavenDependency;
import picocli.CommandLine;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.List;

@Dependent
@CommandLine.Command(name = "search", description = "Search a depedency in maven repository")
public class SearchCommand implements Runnable {

    @Inject
    private MavenService mavenService;

    @CommandLine.Option(names = {"-d", "--dependency"}, description = "Dependency's name")
    private String name;

    @CommandLine.Option(names = {"-l", "--limit"}, description = "Quantity of dependencies to show", defaultValue = "2")
    private String limit;

    @Override
    public void run() {
        List<MavenDependency> dependencies = mavenService.search(name, limit);
        CommandLineTable st = new CommandLineTable();
        st.setShowVerticalLines(true);//if false (default) then no vertical lines are shown
        st.setHeaders("id", "groupId", "artifactId","version","date");//optional - if not used then there will be no header and horizontal lines
        dependencies.forEach(d->{
            st.addRow(d.getId(), d.getGroupId(), d.getArtifactId(), d.getVersion(), d.getFormattedDate());
        });
        st.print();
    }
}
