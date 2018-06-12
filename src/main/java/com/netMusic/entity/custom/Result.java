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
public class Result {

    private List<Songs> songs;
    private int songCount;
    public void setSongs(List<Songs> songs) {
         this.songs = songs;
     }
     public List<Songs> getSongs() {
         return songs;
     }

    public void setSongCount(int songCount) {
         this.songCount = songCount;
     }
     public int getSongCount() {
         return songCount;
     }

}