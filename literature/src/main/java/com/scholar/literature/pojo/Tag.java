package com.scholar.literature.pojo;

import java.util.Map;

public class Tag {
    private String interest;
    private int weight;

    public Tag(Map<String ,Object> map  ){
        setInterest((String) map.get("t"));
        setWeight(map.get("w")==null?0:(Integer) map.get("w"));
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getInterest() {
        return interest;
    }

    public int getWeight() {
        return weight;
    }
}
