package br.com.jmw.command.search;

import br.com.jmw.command.search.dtos.Dependency;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.enterprise.context.Dependent;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Dependent
public class ExternalMavenService {
    private HttpClient httpClient;
    private final String URL_SEARCH_MAVEN =  "https://search.maven.org/solrsearch/select";
    private final String FORMAT =  "json";
    private final String ROWS = "2";
    private String dependency = "guice";

    public ExternalMavenService() {
        this.httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                //.connectTimeout(Duration.ofSeconds(10))
                .build();
    }

    public Dependency searchDependency(){
        try {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(URL_SEARCH_MAVEN+"?q="+dependency+"&rows="+ROWS+"&wt="+FORMAT))
                .build();
            String body = httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
            System.out.println(body);
            return toDependency(body);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  null;
    }

    private Dependency toDependency(String response){
        try {
            ObjectMapper mapper = new ObjectMapper();
            return  mapper.readValue(response, Dependency.class);
        } catch (Exception e) {
            throw  new RuntimeException();
        }
    }
}
