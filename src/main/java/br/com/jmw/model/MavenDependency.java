package br.com.jmw.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

@Getter
@Builder
@AllArgsConstructor
public class MavenDependency {
    @Setter
    private String id;
    private String groupId;
    private String artifactId;
    private String version;
    @Setter
    private LocalDate date;

    public MavenDependency(String groupId, String artifactId, String version) {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
    }

    public String getFormattedDate() {
        StringBuilder builder = new StringBuilder();
        builder.append("(" + this.date.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
        builder.append(" " + this.date.getDayOfMonth());
        builder.append(", "+ this.date.getYear() + ")");
        return builder.toString();
    }
}
