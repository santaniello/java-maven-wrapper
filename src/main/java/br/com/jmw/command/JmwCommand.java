package br.com.jmw.command;

import br.com.jmw.command.search.SearchCommand;
import picocli.CommandLine;

@CommandLine.Command(name="jmw",subcommands = {
        CommandLine.HelpCommand.class
    //    SearchCommand.class
})
public class JmwCommand implements Runnable {
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
    public void run() {
        System.out.print("Teste");
    }
}
