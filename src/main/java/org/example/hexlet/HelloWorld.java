package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.Courses.Course;

import java.util.ArrayList;
import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {
    public static List<Course> courses = new ArrayList<>(List.of(new Course("Java", "Java course"),
                                                                 new Course("PHP", "PHP course"),
                                                                 new Course("Python", "Python course")));

    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });
        app.get("/cources",ctx -> {
            var header = "Курсы по программированию";
            ctx.render("courses/index.jte", model("page", courses,"header", header));
        });
        app.start(7070);
    }
}
