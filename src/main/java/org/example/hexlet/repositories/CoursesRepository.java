package org.example.hexlet.repositories;

import lombok.Getter;
import org.example.hexlet.model.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CoursesRepository {
    @Getter
    private static List<Course> entites = new ArrayList<>();
    public static void save(Course course) {
        course.setId((long) entites.size() + 1);
        entites.add(course);
    }
    public static Optional<Course> find(Long id) {
        return entites.stream().filter(e -> e.getId().equals(id)).findAny();
    }
    public static Optional<Course> findByName(String name) {
        return entites.stream().filter(e -> e.getName().equals(name)).findAny();
    }
    public static boolean existsByName(String name) {
        return entites.stream().anyMatch(e -> e.getName().equals(name));
    }
    public static void clear(){
        entites.clear();
    }
}
