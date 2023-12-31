package com.a2.newsbyte.tag;

import com.a2.newsbyte.news.News;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity(name = "tags")
public class Tag {

    @Id
    private String name;
    private String description;
    private String status;
    @JsonIgnore
    @OneToMany(mappedBy = "tag", fetch = FetchType.LAZY)
    private List<News> news;


    public Tag(){}
    public Tag(Tag tag) {
        this.name=tag.name;
        this.description=tag.description;
        this.status=tag.status;
        this.news=tag.news;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<News> getNews() {
        return Collections.unmodifiableList(news);
    }

    public void setNews(List<News> news) {
        this.news = new ArrayList<>(news);
    }
}
