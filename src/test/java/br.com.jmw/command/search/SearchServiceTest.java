package br.com.jmw.command.search;

import br.com.jmw.IntegrationException;
import br.com.jmw.UnitTestCommon;
import br.com.jmw.model.MavenDependency;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.wildfly.common.Assert;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;

@QuarkusTest
public class SearchServiceTest extends UnitTestCommon {

    @InjectMock
    private MavenRepository mavenRepository;

    @Inject
    private SearchService searchService;

    @Test
    public void should_search_dependencies_in_maven_repository(){
        Mockito.when(mavenRepository.search(anyString(),anyString())).thenReturn(getFileFromResourcesAsString("dependency_test.json"));
        List<MavenDependency> dependencies = searchService.search("guice", "3");
        assertTrue(dependencies.size() == 3);
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
        List<MavenDependency> dependencies = searchService.search("dddddd", "4");
        assertTrue(dependencies.isEmpty());
    }

    @Test
    public void should_return_a_empt_list_when_dependency_name_parameter_is_invalid()  {
        Mockito.when(mavenRepository.search(any(),anyString())).thenThrow(new IllegalArgumentException("The parameter dependency is invalid !"));
        Exception exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () ->  searchService.search(null, "4")
        );
        Assertions.assertEquals(exception.getMessage(), "The parameter dependency is invalid !");
    }


    @Test
    public void should_return_a_error_when_limit_parameter_is_invalid()  {
        Mockito.when(mavenRepository.search(any(),any())).thenThrow(new IllegalArgumentException("The parameter limit is invalid !"));
        Exception exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () ->  searchService.search("guice", null)
        );
        Assertions.assertEquals(exception.getMessage(), "The parameter limit is invalid !");
    }

    @Test
    public void should_pass_along_the_integration_exception_when_maven_repository_throw_it()  {
        Mockito.when(mavenRepository.search(any(),any())).thenThrow(new IntegrationException("Error message"));
        Assertions.assertThrows(
                IntegrationException.class,
                () ->  searchService.search("guice", "4")
        );
    }
}
