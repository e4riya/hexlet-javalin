package org.example.hexlet.dto;

import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.hexlet.model.Course;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BuildCoursePage {
    private Course course;
    private Map<String, List<ValidationError<Object>>> errors;
}
