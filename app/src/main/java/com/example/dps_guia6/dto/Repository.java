package com.example.dps_guia6.dto;

public class Repository {

    private int id;

    private String name;

    private String html_url;

    public Repository(int id, String name, String html_url) {
        this.id = id;
        this.name = name;
        this.html_url = html_url;
    }

    public Repository(String name, String html_url) {
        this.name = name;
        this.html_url = html_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }
}
