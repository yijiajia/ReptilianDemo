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
public class Album {

    private long id;
    private String name;
    private String picUrl;
    private String pic_str;
    private long pic;
    private List<String> alia;
    public void setId(long id) {
         this.id = id;
     }
     public long getId() {
         return id;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setPicUrl(String picUrl) {
         this.picUrl = picUrl;
     }
     public String getPicUrl() {
         return picUrl;
     }

    public void setPic_str(String pic_str) {
         this.pic_str = pic_str;
     }
     public String getPic_str() {
         return pic_str;
     }

    public void setPic(long pic) {
         this.pic = pic;
     }
     public long getPic() {
         return pic;
     }

    public void setAlia(List<String> alia) {
         this.alia = alia;
     }
     public List<String> getAlia() {
         return alia;
     }

}