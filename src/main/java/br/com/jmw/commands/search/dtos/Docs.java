package br.com.jmw.commands.search.dtos;

import java.util.Arrays;


public class Docs {

    private String p;

    private String versionCount;

    private String a;

    private String latestVersion;

    private String g;

    private String repositoryId;

    private String id;

    private String[] text;

    private String[] ec;

    private String timestamp;

    public String getP ()
    {
        return p;
    }

    public void setP (String p)
    {
        this.p = p;
    }

    public String getVersionCount ()
    {
        return versionCount;
    }

    public void setVersionCount (String versionCount)
    {
        this.versionCount = versionCount;
    }

    public String getA ()
    {
        return a;
    }

    public void setA (String a)
    {
        this.a = a;
    }

    public String getLatestVersion ()
    {
        return latestVersion;
    }

    public void setLatestVersion (String latestVersion)
    {
        this.latestVersion = latestVersion;
    }

    public String getG ()
    {
        return g;
    }

    public void setG (String g)
    {
        this.g = g;
    }

    public String getRepositoryId ()
    {
        return repositoryId;
    }

    public void setRepositoryId (String repositoryId)
    {
        this.repositoryId = repositoryId;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String[] getText ()
    {
        return text;
    }

    public void setText (String[] text)
    {
        this.text = text;
    }

    public String[] getEc ()
    {
        return ec;
    }

    public void setEc (String[] ec)
    {
        this.ec = ec;
    }

    public String getTimestamp ()
    {
        return timestamp;
    }

    public void setTimestamp (String timestamp)
    {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Docs{" +
                "p='" + p + '\'' +
                ", versionCount='" + versionCount + '\'' +
                ", a='" + a + '\'' +
                ", latestVersion='" + latestVersion + '\'' +
                ", g='" + g + '\'' +
                ", repositoryId='" + repositoryId + '\'' +
                ", id='" + id + '\'' +
                ", text=" + Arrays.toString(text) +
                ", ec=" + Arrays.toString(ec) +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
