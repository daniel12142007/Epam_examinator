package com.example.epam_examinator.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Section {
    private List<Question> questions;

    @JsonCreator
    public Section(@JsonProperty("questions") List<Question> questions) {
        this.questions = questions;
    }


    public Section() {
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Section{" + "questions=" + questions + '}';
    }
}