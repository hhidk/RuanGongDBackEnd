package com.scholar.literature.pojo;

import java.util.Map;

public class Pub {
   private String id;
   private int rank;
public Pub(Map<String ,Object> map){
   setId((String) map.get("i"));
   setRank(map.get("r")==null?0:(Integer) map.get("r"));
}

   public void setId(String id) {
      this.id = id;
   }

   public void setRank(int rank) {
      this.rank = rank;
   }

   public String getId() {
      return id;
   }

   public int getRank() {
      return rank;
   }
}
