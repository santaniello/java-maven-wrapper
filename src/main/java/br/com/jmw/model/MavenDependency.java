package br.com.jmw.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class MavenDependency {
    private String id;
    private String groupId;
    private String artifactId;
    private String version;
    private Date date;

    public MavenDependency(String groupId, String artifactId, String version) {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
    }

    public String getFormattedDate() {
        return "(Dec 31, 2014)";
    }
}
