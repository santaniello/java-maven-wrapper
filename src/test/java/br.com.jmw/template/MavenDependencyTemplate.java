package br.com.jmw.template;

import br.com.jmw.model.MavenDependency;

public class MavenDependencyTemplate {

    public static final MavenDependency getMavenDependency(){
        MavenDependency dependency = new MavenDependency("com.tomtom.speedtools", "guice", "3.2.21");
        dependency.setId("com.tomtom.speedtools:guice");
        return  dependency;
    }
}
