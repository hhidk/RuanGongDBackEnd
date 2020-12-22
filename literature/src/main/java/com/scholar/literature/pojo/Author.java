package com.scholar.literature.pojo;
import com.carrotsearch.hppc.HashOrderMixing;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Author implements Serializable {
    private int h_index;
    private String id;
    private int n_citation;
    private int n_pubs;
    private String name;
    private String orgs;
    private String position;
    private List<Pub> pubs;
    private List<Tag> tags;

    public Author(Map<String,Object> map){
        Object obj;
        obj = map.get("n_citation");
        n_citation = obj == null ? 0 : (Integer)obj;
        obj = map.get("h_index");
        h_index = obj == null ? 0 : (Integer)obj;
        obj = map.get("n_pubs");
        n_pubs = obj == null ? 0 : (Integer)obj;
        id = (String)map.get("id");
        name = (String)map.get("name");

        position = (String) map.get("position");
        loadorgs(map);
        loadPub(map);
        loadTag(map);
    }
    private void loadorgs(Map<String,Object>map){
    Object ss= map.get("orgs");
    if (ss==null){
        this.orgs="unknown";
        return;
    }
    String s = ss.toString();
    if (s.length()<3){
        this.orgs="unknown";
    }else {
        this.orgs=s.substring(1,s.length()-1);
    }
    }

    private void loadPub(Map<String,Object>map){
        this.pubs=new ArrayList<>();
        ArrayList<Map<String,Object>> ls=(ArrayList<Map<String, Object>>) map.get("pubs");
        if (ls!=null){
            for (Map<String, Object> l : ls) {
                pubs.add(new Pub(l));
            }
        }
    }
    private void loadTag(Map<String ,Object>map){
        this.tags=new ArrayList<>();
        ArrayList<Map<String,Object>> ls=(ArrayList<Map<String, Object>>) map.get("tags");
        if (ls!=null){
            for (Map<String, Object> l : ls) {
                tags.add(new Tag(l));
            }
        }
    }





    public int getH_index() {
        return h_index;
    }

    public String getId() {
        return id;
    }

    public int getN_citation() {
        return n_citation;
    }

    public int getN_pubs() {
        return n_pubs;
    }

    public String getName() {
        return name;
    }

    public String getOrgs() {
        return orgs;
    }

    public String getPosition() {
        return position;
    }

    public List<Pub> getPubs() {
        return pubs;
    }

    public List<Tag> getTags() {
        return tags;
    }

}
