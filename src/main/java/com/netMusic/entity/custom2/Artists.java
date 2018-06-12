/**
  * Copyright 2018 bejson.com 
  */
package com.netMusic.entity.custom2;
import java.util.List;

/**
 * Auto-generated: 2018-06-10 20:8:39
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Artists {

    private int id;
    private String name;
    private List<String> alia;
    public void setId(int id) {
         this.id = id;
     }
     public int getId() {
         return id;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setAlia(List<String> alia) {
         this.alia = alia;
     }
     public List<String> getAlia() {
         return alia;
     }

}