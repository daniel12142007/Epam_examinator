package com.example.epam_examinator.model;

import javax.persistence.*;

import lombok.*;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<Question> questions;

    public Section(List<Question> questions) {
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", questions=" + questions +
                '}';
    }
}