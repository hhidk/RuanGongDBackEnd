package com.scholar.literature.pojo;

import java.util.Map;

public class LitAuthor {
    String name;
    String id;
    String orgs;
public LitAuthor(Map<String,Object> map){
    name=(String) map.get("name");
    id=(String)map.get("id");
    orgs=(String) map.get("orgs");
}


    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOrgs(String orgs) {
        this.orgs = orgs;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getOrgs() {
        return orgs;
    }
}
