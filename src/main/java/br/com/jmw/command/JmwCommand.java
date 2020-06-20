package br.com.jmw.command;

import br.com.jmw.command.search.dtos.Dependency;
import com.fasterxml.jackson.databind.ObjectMapper;
import picocli.CommandLine;

import javax.enterprise.context.Dependent;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.Callable;

@Dependent
@CommandLine.Command(name = "jmw", mixinStandardHelpOptions = true, description = "Greet person by their name")
public class JmwCommand implements Callable<Integer> {
    private final String URL_SEARCH_MAVEN =  "https://search.maven.org/solrsearch/select";
    private final String FORMAT =  "json";
    private final String ROWS = "2";
    private String dependency = "guice";

//    public void run() {
//        System.out.println("Teste");

//        try {
//            HttpClient httpClient = HttpClient.newBuilder()
//                    .version(HttpClient.Version.HTTP_1_1)
//                    //.connectTimeout(Duration.ofSeconds(10))
//                    .build();
//            HttpRequest request = HttpRequest.newBuilder()
//                    .GET()
//                    .uri(URI.create(URL_SEARCH_MAVEN+"?q="+dependency+"&rows="+ROWS+"&wt="+FORMAT))
//                    .build();
//
//            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//            ObjectMapper mapper = new ObjectMapper();
//            Dependency dependency = mapper.readValue(response.body(), Dependency.class);
//            System.out.println(response.body());
//            System.out.println(dependency);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    //}

    @Override
    public Integer call() throws Exception {
        System.out.print("Teste");
        return  0;
    }
}
