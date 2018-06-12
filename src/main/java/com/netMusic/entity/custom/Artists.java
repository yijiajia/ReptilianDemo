/**
  * Copyright 2018 bejson.com 
  */
package com.netMusic.entity.custom;
import java.util.List;

/**
 * Auto-generated: 2018-06-06 20:59:46
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Artists {

    private String name;
    private int id;
    private Long picId;
    private int img1v1Id;
    private String briefDesc;
    private String picUrl;
    private String img1v1Url;
    private int albumSize;
    private List<String> alias;
    private String trans;
    private int musicSize;
    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setId(int id) {
         this.id = id;
     }
     public int getId() {
         return id;
     }

    public Long getPicId() {
        return picId;
    }

    public void setPicId(Long picId) {
        this.picId = picId;
    }

    public void setImg1v1Id(int img1v1Id) {
         this.img1v1Id = img1v1Id;
     }
     public int getImg1v1Id() {
         return img1v1Id;
     }

    public void setBriefDesc(String briefDesc) {
         this.briefDesc = briefDesc;
     }
     public String getBriefDesc() {
         return briefDesc;
     }

    public void setPicUrl(String picUrl) {
         this.picUrl = picUrl;
     }
     public String getPicUrl() {
         return picUrl;
     }

    public void setImg1v1Url(String img1v1Url) {
         this.img1v1Url = img1v1Url;
     }
     public String getImg1v1Url() {
         return img1v1Url;
     }

    public void setAlbumSize(int albumSize) {
         this.albumSize = albumSize;
     }
     public int getAlbumSize() {
         return albumSize;
     }

    public void setAlias(List<String> alias) {
         this.alias = alias;
     }
     public List<String> getAlias() {
         return alias;
     }

    public void setTrans(String trans) {
         this.trans = trans;
     }
     public String getTrans() {
         return trans;
     }

    public void setMusicSize(int musicSize) {
         this.musicSize = musicSize;
     }
     public int getMusicSize() {
         return musicSize;
     }

}