package br.com.jmw.command.search;

import br.com.jmw.UnitTestCommon;
import br.com.jmw.model.MavenDependency;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.wildfly.common.Assert;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;

@QuarkusTest
public class MavenServiceTest extends UnitTestCommon {

    @InjectMock
    private MavenRepository mavenRepository;

    @Inject
    private MavenService mavenService;

    @Test
    public void should_search_dependencies_in_maven_repository(){
        Mockito.when(mavenRepository.search(anyString(),anyString())).thenReturn(getFileFromResourcesAsString("dependency_test.json"));
        List<MavenDependency> dependencies = mavenService.search("guice", "5");
        assertTrue(dependencies.size() > 0);
        dependencies.forEach(d->{
            Assert.assertNotNull(d.getId());
            Assert.assertNotNull(d.getGroupId());
            Assert.assertNotNull(d.getArtifactId());
            Assert.assertNotNull(d.getVersion());
            Assert.assertNotNull(d.getDate());
        });
    }

    @Test
    public void should_return_a_empt_list_when_dependency_does_not_found()  {
        Mockito.when(mavenRepository.search(anyString(),anyString())).thenReturn("");
        List<MavenDependency> dependencies = mavenService.search("dddddd", "4");
        assertTrue(dependencies.isEmpty());
    }

    @Test
    public void should_return_a_empt_list_when_parameters_are_invalid()  {
        List<MavenDependency> dependencies = mavenService.search(null, "4");
        assertTrue(dependencies.isEmpty());
    }
}
