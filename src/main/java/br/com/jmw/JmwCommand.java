package br.com.jmw;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;


public class JmwCommand  implements QuarkusApplication {


    @Override
    public int run(String... args) throws Exception {
        System.out.println("aeeeee");
        if(args.length == 0) {
            Quarkus.waitForExit();
            return 0;
        }
        return 0;
    }
}
