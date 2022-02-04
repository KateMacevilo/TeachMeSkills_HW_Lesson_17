package com.teachMeSkills.lesson_17.model;

import java.util.List;

public class Sonnet {

    private String authorFirstName;
    private String authorLastName;
    private String title;
    private List<String> sonnetLines;


    public Sonnet(String authorFirstName, String authorLastName, String title, List<String> sonnetLines) {
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.title = title;
        this.sonnetLines = sonnetLines;
    }

    public Sonnet() {
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getSonnetLines() {
        return sonnetLines;
    }

    public void setSonnetLines(List<String> sonnetLines) {
        this.sonnetLines = sonnetLines;
    }

    @Override
    public String toString() {
        return "Sonnet " +
                "authorFirstName='" + authorFirstName +
                ", authorLastName='" + authorLastName +
                ", title='" + title +
                " sonnetLines= " + sonnetLines;
    }

}
