package org.example.hexlet.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public final class Course {
    private Long id;

    @ToString.Include
    private String name;
    private String description;
    private String content;

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
