package br.com.jmw.command.search;

import br.com.jmw.IntegrationException;
import br.com.jmw.command.search.dto.MavenResponseDTO;
import br.com.jmw.model.MavenDependency;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class SearchService {

    @Inject
    private MavenRepository mavenRepository;

    public List<MavenDependency> search(String dependencyName, String limit) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String reponse = mavenRepository.search(dependencyName, limit);
            MavenResponseDTO mavenResponseDTO = mapper.readValue(reponse, MavenResponseDTO.class);
            return new  MapperToMavenDependency().toMavenDependency(mavenResponseDTO);
        }catch (IllegalArgumentException ex){
            throw new IllegalArgumentException(ex.getMessage());
        }catch(IntegrationException ex){
            throw new IntegrationException(ex.getMessage());
        }catch(Exception ex){
           return Collections.emptyList();
        }
    }
}
