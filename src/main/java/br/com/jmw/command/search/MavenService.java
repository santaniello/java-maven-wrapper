package br.com.jmw.command.search;

import br.com.jmw.command.search.dto.MavenResponseDTO;
import br.com.jmw.model.MavenDependency;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class MavenService {

    @Inject
    private MavenRepository mavenRepository;

    public List<MavenDependency> search(String dependencyName, String limit) {
        try {
            validParameters(dependencyName,limit);
            ObjectMapper mapper = new ObjectMapper();
            String reponse = mavenRepository.search(dependencyName, limit);
            MavenResponseDTO mavenResponseDTO = mapper.readValue(reponse, MavenResponseDTO.class);
            return new  MapperToMavenDependency().toMavenDependency(mavenResponseDTO);
        }catch(Exception ex){
           return Collections.emptyList();
        }
    }

    // TODO Improve this validation!
    private void validParameters(String dependencyName, String limit){
       if(dependencyName == null || dependencyName.equals("") || limit == null ||limit.equals("")){
          throw new IllegalArgumentException("The parameter dependency and limit are mandatory!");
       }
    }
}
