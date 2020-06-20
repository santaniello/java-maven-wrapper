package br.com.jmw.command.search.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@RegisterForReflection
public class Docs {
    private String p;
    private String versionCount;
    private String a;
    private String latestVersion;
    private String g;
    private String repositoryId;
    private String id;
    private String[] text;
    private String[] ec;
    private String timestamp;
}
