package br.com.jmw.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

@Getter
@Builder
@Accessors(prefix = {"_"})
@AllArgsConstructor
public class MavenDependency {
    @Setter
    private String _id;
    private String _groupId;
    private String _artifactId;
    private String _version;
    @Setter
    private LocalDate _date;

    public MavenDependency(String groupId, String artifactId, String version) {
        _groupId = groupId;
        _artifactId = artifactId;
        _version = version;
    }

    public String getFormattedDate() {
        StringBuilder builder = new StringBuilder();
        builder.append("(" + _date.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
        builder.append(" " + _date.getDayOfMonth());
        builder.append(", "+ _date.getYear() + ")");
        return builder.toString();
    }
}
