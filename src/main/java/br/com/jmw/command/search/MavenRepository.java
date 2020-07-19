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
    private HttpClient httpClient;
    //private final String URL_SEARCH_MAVEN =  "https://search.maven.org/solrsearch/select";
    private final String EXTENSION =  "json";
    @ConfigProperty(name = "maven.url")
    private String _url;

    public MavenRepository() {
        this.httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                //.connectTimeout(Duration.ofSeconds(10))
                .build();
    }

    public String search(String dependency, String limit){
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(_url+"?q="+dependency+"&rows="+limit+"&wt="+EXTENSION))
                    .build();
            return httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
