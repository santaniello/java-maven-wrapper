package br.com.jmw.command.search.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@RegisterForReflection
public class MavenResponseDTO {
    private DependenciesDTO response;
}
