package br.com.jmw.template;

import br.com.jmw.model.MavenDependency;

import java.time.LocalDate;

public class MavenDependencyTemplate {

    public static final MavenDependency getMavenDependency(){
        MavenDependency dependency = new MavenDependency("com.tomtom.speedtools", "guice", "3.2.21");
        dependency.setId("com.tomtom.speedtools:guice");
        dependency.setDate(LocalDate.of(2014, 12, 31));
        return  dependency;
    }
}
