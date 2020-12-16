package com.scholar.literature.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;


public class Literature {
    private String id;
    private String title;
    private List<LitAuthor> authors;
    private List<String> url;
    private String issue;
    private String doi;
    private int n_citation;
    private List<String> keywords;
    private String page_start;
    private String page_end;
    private Venue venue;
    private String volume;
    private int year;
    private String isbn;
    private String issn;
    private String pdf;
    private String abstracts;

    public Literature(Map<String, Object> map) {
        Object obj;
        Map<String,Object>mapve;
        obj = map.get("venue");

        if (obj!=null){
        Object ob;
            mapve=(Map<String, Object>)obj;
            venue=new Venue();
            ob = mapve.get("raw");
            venue.setRaw(ob==null?null:(String)ob);
            ob = mapve.get("id");
            venue.setId((ob==null?null:(String)ob));
        }
        obj = map.get("title");
        title = (obj == null) ? null : (String) obj;

        obj = map.get("authors");
        authors = obj == null ? null : (List<LitAuthor>) obj;

        obj = map.get("id");
        id = obj == null ? null : (String) obj;

        obj = map.get("doi");
        doi = obj == null ? null : (String) obj;

        obj = map.get("url");
        url = obj == null ? null : (List<String>) obj;

        obj = map.get("issue");
        issue = obj == null ? null : (String) obj;

        obj = map.get("n_citation");
        n_citation = obj == null ? null : (int) obj;

        obj = map.get("keywords");
        keywords = obj == null ? null : (List<String>) obj;

        obj = map.get("page_start");
        page_start = obj == null ? null : (String) obj;

        obj = map.get("page_end");
        page_end = obj == null ? null : (String) obj;

        obj = map.get("volume");
        volume   = obj == null ? null : (String) obj;

        obj = map.get("year");
        year = obj == null ? null : (int) obj;

        obj = map.get("issn");
        issn = obj == null ? null : (String) obj;

        obj = map.get("isbn");
        isbn = obj == null ? null : (String) obj;

        obj = map.get("pdf");
        pdf = obj == null ? null : (String) obj;

        obj = map.get("abstract");
        abstracts = obj == null ? null : (String) obj;
    }


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<LitAuthor> getAuthors() {
        return authors;
    }

    public List<String> getUrl() {
        return url;
    }

    public String getIssue() {
        return issue;
    }

    public String getDoi() {
        return doi;
    }

    public int getN_citation() {
        return n_citation;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public String getPage_start() {
        return page_start;
    }

    public String getPage_end() {
        return page_end;
    }

    public Venue getVenues() {
        return venue;
    }

    public String getVolume() {
        return volume;
    }

    public int getYear() {
        return year;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getIssn() {
        return issn;
    }

    public String getPdf() {
        return pdf;
    }

    public String getAbstracts() {
        return abstracts;
    }


}
/**
 * venue:class java.util.HashMap
 * authors:class java.util.ArrayList *
 * doi:class java.lang.String *
 * id:class java.lang.String *
 * title:class java.lang.String *
 * isbn:null
 * issn:class java.lang.String
 * issue:class java.lang.String
 * keywords:class java.util.ArrayList
 * lang:class java.lang.String
 * n_citation:class java.lang.Integer
 * page_end:class java.lang.String
 * page_start:class java.lang.String
 * pdf:null
 * url:class java.util.ArrayList
 * volume:class java.lang.String
 * year:class java.lang.Integer
 */
