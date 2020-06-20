package br.com.jmw.command.search.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.runtime.annotations.RegisterForReflection;

@JsonIgnoreProperties(ignoreUnknown = true)
@RegisterForReflection
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
