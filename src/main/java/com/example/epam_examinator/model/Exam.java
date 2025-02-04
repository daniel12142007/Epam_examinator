package com.example.epam_examinator.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public class Exam {
    private String title;
    private List<Section> sections;

    @JsonCreator
    public Exam(@JsonProperty("title") String title, @JsonProperty("selections") List<Section> sections) {
        this.title = title;
        this.sections = sections;
    }

    public Exam(String title) {
        this.title = title;
    }

    public Exam() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "title='" + title + '\'' +
                ", sections=" + sections +
                '}';
    }
}