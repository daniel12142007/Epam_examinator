package com.example.epam_examinator.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @OneToMany
    private List<Section> sections;

    public Exam(String title, List<Section> sections) {
        this.title = title;
        this.sections = sections;
    }
}