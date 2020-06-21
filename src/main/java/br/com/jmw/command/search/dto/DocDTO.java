package br.com.jmw.command.search.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@RegisterForReflection
@JsonIgnoreProperties(ignoreUnknown = true)
public class DocDTO {
    private String p;
    private String versionCount;
    @JsonProperty("a")
    private String artifactId;
    private String latestVersion;
    @JsonProperty("g")
    private String groupId;
    private String repositoryId;
    private String id;
    private String[] text;
    private String[] ec;
    private Date timestamp;
}
