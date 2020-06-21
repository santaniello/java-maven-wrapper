package br.com.jmw.command.search.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@RegisterForReflection
public class DependenciesDTO {
    private DocDTO[] docs;
    private String numFound;
    private String start;
}
