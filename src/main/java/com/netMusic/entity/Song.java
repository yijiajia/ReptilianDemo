package com.netMusic.entity;

public class Song {
    private Long id;

    private String commentThreadId;

    private String mp3url;

    private String name;

    private Integer recordId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentThreadId() {
        return commentThreadId;
    }

    public void setCommentThreadId(String commentThreadId) {
        this.commentThreadId = commentThreadId;
    }

    public String getMp3url() {
        return mp3url;
    }

    public void setMp3url(String mp3url) {
        this.mp3url = mp3url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", commentThreadId='" + commentThreadId + '\'' +
                ", mp3url='" + mp3url + '\'' +
                ", name='" + name + '\'' +
                ", recordId=" + recordId +
                '}';
    }
}