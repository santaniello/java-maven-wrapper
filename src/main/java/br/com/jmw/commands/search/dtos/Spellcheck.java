package br.com.jmw.commands.search.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Spellcheck {
    private String[] suggestions;

    public String[] getSuggestions ()
    {
        return suggestions;
    }

    public void setSuggestions (String[] suggestions)
    {
        this.suggestions = suggestions;
    }


    @Override
    public String toString() {
        return "Spellcheck{" +
                "suggestions=" + Arrays.toString(suggestions) +
                '}';
    }
}
