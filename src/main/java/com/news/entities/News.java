package com.news.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class News extends Entity {

    private String title;
    private String shortText;
    private String fullText;
    private LocalDate publishedIn;
    private LocalDate createdTn;
    private  Author author;
    private List<Tag> tags;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortText() {
        return shortText;
    }

    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public LocalDate getPublishedIn() {
        return publishedIn;
    }

    public void setPublishedIn(LocalDate publishedIn) {
        this.publishedIn = publishedIn;
    }

    public LocalDate getCreatedTn() {
        return createdTn;
    }

    public void setCreatedTn(LocalDate createdTn) {
        this.createdTn = createdTn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        News news = (News) o;
        return Objects.equals(getTitle(), news.getTitle()) &&
                Objects.equals(getShortText(), news.getShortText()) &&
                Objects.equals(getFullText(), news.getFullText()) &&
                Objects.equals(getPublishedIn(), news.getPublishedIn()) &&
                Objects.equals(getCreatedTn(), news.getCreatedTn()) &&
                Objects.equals(getAuthor(), news.getAuthor()) &&
                Objects.equals(getTags(), news.getTags());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getShortText(), getFullText(), getPublishedIn(), getCreatedTn(), getAuthor(), getTags());
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", shortText='" + shortText + '\'' +
                ", fullText='" + fullText + '\'' +
                ", publishedIn=" + publishedIn +
                ", createdTn=" + createdTn +
                ", author=" + author +
                ", tags=" + tags +
                '}';
    }
}

