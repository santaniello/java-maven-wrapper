package br.com.jmw.command.search;

import br.com.jmw.command.search.dto.DocDTO;
import br.com.jmw.command.search.dto.MavenResponseDTO;
import br.com.jmw.model.MavenDependency;

import java.util.ArrayList;
import java.util.List;

public class MapperToMavenDependency {

    public List<MavenDependency> toMavenDependency(MavenResponseDTO responseDTO){
        DocDTO[] docs = responseDTO.getResponse().getDocs();
        List<MavenDependency> dependencies = new ArrayList<>();
        for(int count = 0; count < docs.length; count++){
            dependencies.add(
                MavenDependency.builder()
                   .id(docs[count].getId())
                   .groupId(docs[count].getGroupId())
                   .artifactId(docs[count].getArtifactId())
                   .version(docs[count].getLatestVersion())
                   .date(docs[count].getTimestamp())
                   .build()
            );
        }
        return  dependencies;
    }
}
