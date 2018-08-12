/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.models;

/**
 *
 * @author ASUS I7
 */
public class Feed {

    private String guid;
    private String title;
    private String link;
    private String description;
    private String creator;
    private String category;
    private String pubDate;

    public Feed() {

    }

    public Feed(String guid, String title, String link, String description, String creator, String category, String pubDate) {
        this.guid = guid;
        this.title = title;
        this.link = link;
        this.description = description;
        this.creator = creator;
        this.category = category;
        this.pubDate = pubDate;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

}
