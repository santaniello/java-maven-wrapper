package br.com.jmw.command.search;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@ApplicationScoped
public class MavenRepository {

    private HttpClient _httpClient;

    private final String EXTENSION =  "json";

    @ConfigProperty(name = "maven.url")
    private String _url;

    public MavenRepository() {
        _httpClient = HttpClient.newBuilder()
              .version(HttpClient.Version.HTTP_1_1)
               //.connectTimeout(Duration.ofSeconds(10))
              .build();
    }

    public String search(String dependency, String limit){
        validParameters(dependency,limit);
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(_url+"?q="+dependency+"&rows="+limit+"&wt="+EXTENSION))
                    .build();
            return _httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  null;
    }

    private void validParameters(String dependencyName, String limit){
        if(dependencyName == null || dependencyName.isEmpty() || dependencyName.isBlank() )
            throw new IllegalArgumentException("The parameter dependency is invalid !");

        if(limit == null || limit.isEmpty() || limit.isBlank())
            throw new IllegalArgumentException("The parameter limit is invalid !");
    }
}
