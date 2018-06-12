
package com.netMusic.entity;
import java.util.List;

/**
 * Auto-generated: 2018-06-06 14:1:37
 *
 */
public class Result {

    private List<Song> songs;
    private int songCount;
    public void setSongs(List<Song> songs) {
         this.songs = songs;
     }
     public List<Song> getSongs() {
         return songs;
     }

    public void setSongCount(int songCount) {
         this.songCount = songCount;
     }
     public int getSongCount() {
         return songCount;
     }

    @Override
    public String toString() {
        return "Result{" +
                "songs=" + songs +
                ", songCount=" + songCount +
                '}';
    }
}