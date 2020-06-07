package br.com.jmw.commands.search.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Params {

    private String indent;

    private String fl;

    private String start;

    private String sort;

    private String rows;

    private String version;

    private String q;

    private String core;

    private String defType;

    private String spellcheck;

    private String qf;

    private String wt;

    public String getIndent ()
    {
        return indent;
    }

    public void setIndent (String indent)
    {
        this.indent = indent;
    }

    public String getFl ()
    {
        return fl;
    }

    public void setFl (String fl)
    {
        this.fl = fl;
    }

    public String getStart ()
    {
        return start;
    }

    public void setStart (String start)
    {
        this.start = start;
    }

    public String getSort ()
    {
        return sort;
    }

    public void setSort (String sort)
    {
        this.sort = sort;
    }

    public String getRows ()
    {
        return rows;
    }

    public void setRows (String rows)
    {
        this.rows = rows;
    }

    public String getVersion ()
    {
        return version;
    }

    public void setVersion (String version)
    {
        this.version = version;
    }

    public String getQ ()
    {
        return q;
    }

    public void setQ (String q)
    {
        this.q = q;
    }

    public String getCore ()
    {
        return core;
    }

    public void setCore (String core)
    {
        this.core = core;
    }

    public String getDefType ()
    {
        return defType;
    }

    public void setDefType (String defType)
    {
        this.defType = defType;
    }

    public String getSpellcheck ()
    {
        return spellcheck;
    }

    public void setSpellcheck (String spellcheck)
    {
        this.spellcheck = spellcheck;
    }

    public String getQf ()
    {
        return qf;
    }

    public void setQf (String qf)
    {
        this.qf = qf;
    }

    public String getWt ()
    {
        return wt;
    }

    public void setWt (String wt)
    {
        this.wt = wt;
    }

    @Override
    public String toString() {
        return "Params{" +
                "indent='" + indent + '\'' +
                ", fl='" + fl + '\'' +
                ", start='" + start + '\'' +
                ", sort='" + sort + '\'' +
                ", rows='" + rows + '\'' +
                ", version='" + version + '\'' +
                ", q='" + q + '\'' +
                ", core='" + core + '\'' +
                ", defType='" + defType + '\'' +
                ", spellcheck='" + spellcheck + '\'' +
                ", qf='" + qf + '\'' +
                ", wt='" + wt + '\'' +
                '}';
    }
}
