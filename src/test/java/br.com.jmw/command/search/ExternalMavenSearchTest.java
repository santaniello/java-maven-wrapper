package br.com.jmw.command.search;

import br.com.jmw.command.search.dto.DocDTO;
import br.com.jmw.command.search.dto.MavenResponseDTO;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class ExternalMavenSearchTest {
    private ExternalMavenService service = new ExternalMavenService();

    @Test
    public void test(){
        MavenResponseDTO mavenResponseDTO = service.search("guice", "2");
        System.out.println(mavenResponseDTO.getResponse().getNumFound());
        DocDTO[] docs = mavenResponseDTO.getResponse().getDocs();
        for (DocDTO d : docs) {
            System.out.println(d.getGroupId());
        }

    }
}
