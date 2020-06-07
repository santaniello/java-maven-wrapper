package br.com.jmw.commands.search.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Dependency {
    private Response response;

    public Response getResponse ()
    {
        return response;
    }

    public void setResponse (Response response)
    {
        this.response = response;
    }


    @Override
    public String toString() {
        return "Dependency{" +
                " response=" + response +
                '}';
    }
}
