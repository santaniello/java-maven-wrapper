package br.com.jmw.model;

import br.com.jmw.UnitTestCommon;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static br.com.jmw.template.MavenDependencyTemplate.getMavenDependency;

@QuarkusTest
public class MavenDependencyTest extends UnitTestCommon {

    @Test
    public void should_format_date(){
        MavenDependency dependency = getMavenDependency();
        Assertions.assertEquals("(Dec 31, 2014)",dependency.getFormattedDate());
    }
}
