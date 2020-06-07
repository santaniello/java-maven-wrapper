package br.com.jmw.commands.search.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseHeader {
    private String QTime;

    private Params params;

    private String status;

    public String getQTime ()
    {
        return QTime;
    }

    public void setQTime (String QTime)
    {
        this.QTime = QTime;
    }

    public Params getParams ()
    {
        return params;
    }

    public void setParams (Params params)
    {
        this.params = params;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ResponseHeader{" +
                "QTime='" + QTime + '\'' +
                ", params=" + params +
                ", status='" + status + '\'' +
                '}';
    }
}
