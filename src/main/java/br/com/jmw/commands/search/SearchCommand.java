package br.com.jmw.commands.search;

import br.com.jmw.commands.search.dtos.Dependency;
import com.fasterxml.jackson.databind.ObjectMapper;
import picocli.CommandLine;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "search"
)
public class SearchCommand implements Callable<Integer> {

    private final String URL_SEARCH_MAVEN =  "http://search.maven.org/solrsearch/select";
    private final String FORMAT =  "json";
    private final String ROWS = "2";
    @CommandLine.Option(names = {"-d", "--dependency"})
    private String dependency;

    @Override
    public Integer call() {
        System.out.println("The popular search command with dependency : " + dependency);
        try {
            HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                //.connectTimeout(Duration.ofSeconds(10))
                .build();
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(URL_SEARCH_MAVEN+"?q="+dependency+"&rows="+ROWS+"&wt="+FORMAT))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            Dependency dependency = mapper.readValue(response.body(), Dependency.class);
            System.out.println(response.body());
            System.out.println(dependency);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
