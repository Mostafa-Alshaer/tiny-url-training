package com.example.tinyurltraining.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "urls")
public class URLEntity {

    @Id
    private String id;
    private String key;
    private String longURL;
    
    public URLEntity() {
    }

    public URLEntity(String longURL) {
        this.longURL = longURL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLongURL() {
        return longURL;
    }

    public void setLongURL(String longURL) {
        this.longURL = longURL;
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", key=" + key + ", longURL=" + longURL + "]";
    }
}
