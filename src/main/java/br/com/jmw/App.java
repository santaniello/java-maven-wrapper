package br.com.jmw;

import br.com.jmw.commands.search.dtos.Dependency;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Dependency obj = mapper.readValue(new File("teste.json"), Dependency.class);
        System.out.println(obj);
    }
}
