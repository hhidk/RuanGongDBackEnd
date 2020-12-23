package com.scholar.literature.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    private String refMLA = "placeholder";
    private String refAPA = "placeholder";
    private String abstracts;

    public Venue getVenue() {
        return venue;
    }

    public String getRefMLA() {
        return refMLA;
    }

    public String getRefAPA() {
        return refAPA;
    }

    public Map<String, Object> retRelationMap() {
        Map<String, Object> ret = new HashMap<>();
        List<Map<String, Object>> authorlist = new ArrayList<>();
        ret.put("literatureID", this.id);
        ret.put("title", this.title);
        for (LitAuthor author : authors) {
            Map<String, Object> ma = new HashMap<>();
            ma.put("authorID", author.getId());
            ma.put("realName", author.getName());
            authorlist.add(ma);
        }
        ret.put("authors",authorlist);
        ret.put("abstract", this.abstracts);
        ret.put("keyWord", this.keywords);
        ret.put("year", this.year);
        ret.put("n_citation", n_citation);
        return ret;
    }

    public Map<String, Object> retGetMymap() {
        Map<String, Object> ret = new HashMap<>();
        List<Map<String, Object>> authorlist = new ArrayList<>();
        ret.put("literatureID", this.id);
        ret.put("title", this.title);
        ret.put("keyWord", this.keywords);
        ret.put("citation",this.n_citation);
        for (LitAuthor author : authors) {
            Map<String, Object> ma = new HashMap<>();
            ma.put("authorID", author.getId());
            ma.put("realName", author.getName());
            authorlist.add(ma);
        }
        ret.put("authors",authorlist);
        ret.put("venue", this.venue == null ? null : this.venue.getRaw());
        return ret;
    }
    public Map<String,Object>retSearchMap(){
        Map<String, Object> ret = new HashMap<>();
        List<Map<String, Object>> authorlist = new ArrayList<>();
        ret.put("literatureID", this.id);
        ret.put("title", this.title);
        for (LitAuthor author : authors) {
            Map<String, Object> ma = new HashMap<>();
            ma.put("authorID", author.getId());
            ma.put("realName", author.getName());
            authorlist.add(ma);
        }
        ret.put("authors",authorlist);
        ret.put("venue", this.venue == null ? null : this.venue.getRaw());
        ret.put("year",this.year);
        ret.put("ciation",this.n_citation);
        ret.put("MLAformat", this.refMLA);
        ret.put("APAformat", this.refAPA);
        return ret;
    }

    public Map<String, Object> retGetmap() {
        Map<String, Object> ret = new HashMap<>();
        Map<String, Object> rret = new HashMap<>();
        ret.put("year",this.year);
        ret.put("literatureID", this.id);
        ret.put("title", this.title);
        ret.put("abstract", this.abstracts);
        ret.put("keyWord", this.keywords);
        ret.put("authors", this.authors.stream().map(LitAuthor::getId).collect(Collectors.toList()));
        ret.put("download", this.pdf);
        ret.put("doi", this.doi);
        ret.put("MLAformat", this.refMLA);
        ret.put("APAformat", this.refAPA);
        ret.put("venue", this.venue == null ? null : this.venue.getRaw());
        rret.put("literature", ret);
        return rret;
    }

    private void parseVenue(Map<String, Object> map) {
        Map<String, Object> mapve = (Map<String, Object>) map.get("venue");
        if (mapve != null) {
            venue = new Venue();
            venue.setRaw((String) mapve.get("raw"));
            venue.setId(((String) mapve.get("id")));
        }
    }

    private void parseAuthors(Map<String, Object> map) {
        this.authors = new ArrayList<>();
        ArrayList<Map<String, Object>> ls = (ArrayList<Map<String, Object>>) map.get("authors");
        if (ls != null) {
            for (Map<String, Object> l : ls) {
               if (l.get("id")!=null){
                    authors.add(new LitAuthor(l));
                }
            }
        }
    }

    public Literature(Map<String, Object> map) {
        Object obj;
        parseVenue(map);
        parseAuthors(map);
        title = (String) map.get("title");
        id = (String) map.get("id");
        doi = (String) map.get("doi");
        url = (List<String>) map.get("url");
        issue = (String) map.get("issue");
        obj = map.get("n_citation");
        n_citation = obj == null ? 0 : (Integer) obj;
        keywords = (List<String>) map.get("keywords");
        page_start = (String) map.get("page_start");
        page_end = (String) map.get("page_end");
        volume = (String) map.get("volume");
        obj = map.get("year");
        year = obj == null ? 0 : (Integer) obj;
        issn = (String) map.get("issn");
        isbn = (String) map.get("isbn");
        pdf = (String) map.get("pdf");
        abstracts = (String) map.get("abstract");
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
 * {
 * raw:venue name
 * id :venue id
 * }
 * authors:class java.util.ArrayList *
 * {
 * org,
 * name,
 * id
 * }
 * doi:class java.lang.String *
 * id:class java.lang.String *
 * title:class java.lang.String *
 * isbn:null
 * issn:class java.lang.String
 * issue:class java.lang.String
 * keywords:class java.util.ArrayList
 * {
 * keywords
 * }
 * lang:class java.lang.String
 * n_citation:class java.lang.Integer
 * page_end:class java.lang.String
 * page_start:class java.lang.String
 * pdf:class java.lang.String
 * url:class java.util.ArrayList
 * volume:class java.lang.String
 * year:class java.lang.Integer
 */
