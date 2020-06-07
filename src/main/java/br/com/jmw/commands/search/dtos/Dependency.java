package br.com.jmw.commands.search.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Dependency {
    private Spellcheck spellcheck;
    private Response response;
    private ResponseHeader responseHeader;

    public Spellcheck getSpellcheck ()
    {
        return spellcheck;
    }

    public void setSpellcheck (Spellcheck spellcheck)
    {
        this.spellcheck = spellcheck;
    }

    public Response getResponse ()
    {
        return response;
    }

    public void setResponse (Response response)
    {
        this.response = response;
    }

    public ResponseHeader getResponseHeader ()
    {
        return responseHeader;
    }

    public void setResponseHeader (ResponseHeader responseHeader)
    {
        this.responseHeader = responseHeader;
    }

    @Override
    public String toString() {
        return "Dependency{" +
                "spellcheck=" + spellcheck +
                ", response=" + response +
                ", responseHeader=" + responseHeader +
                '}';
    }
}
