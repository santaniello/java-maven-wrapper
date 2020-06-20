package br.com.jmw.command.search.dtos;

import java.util.Arrays;


public class Response {

    private Docs[] docs;

    private String numFound;

    private String start;

    public Docs[] getDocs ()
    {
        return docs;
    }

    public void setDocs (Docs[] docs)
    {
        this.docs = docs;
    }

    public String getNumFound ()
    {
        return numFound;
    }

    public void setNumFound (String numFound)
    {
        this.numFound = numFound;
    }

    public String getStart ()
    {
        return start;
    }

    public void setStart (String start)
    {
        this.start = start;
    }

    @Override
    public String toString() {
        return "Response{" +
                "docs=" + Arrays.toString(docs) +
                ", numFound='" + numFound + '\'' +
                ", start='" + start + '\'' +
                '}';
    }
}
