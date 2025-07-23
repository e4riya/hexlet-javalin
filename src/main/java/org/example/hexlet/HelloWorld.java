package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;
import io.javalin.validation.ValidationException;
import org.example.hexlet.dto.BuildCoursePage;
import org.example.hexlet.dto.CoursePage;
import org.example.hexlet.dto.CoursesPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.repositories.CoursesRepository;

import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {

    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            String title = "Hello";
            ctx.render("hello.jte", model("title", title));
        });
        app.get(NamedRoutes.coursesPath(), ctx -> {
            var rawTerm = ctx.queryParam("term");
            List<Course> courses = CoursesRepository.getEntites();
            if (rawTerm != null) {
                var term = rawTerm.trim().toLowerCase();
                courses = courses.stream()
                                 .filter(course -> {
                                     var lowerCaseCourseName = course.getName().toLowerCase();
                                     return lowerCaseCourseName.contains(term);
                                 })
                                 .toList();
            }

            CoursesPage page = new CoursesPage(courses, rawTerm);
            ctx.render("courses/courses.jte", model("page", page));
        });
        app.get(NamedRoutes.buildCoursePath(), ctx -> {
            var page = new BuildCoursePage();
            ctx.render("courses/courseBuild.jte", model("page", page));
        });
        app.get(NamedRoutes.coursePath("{id}"), ctx -> {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            Course course = CoursesRepository.find(id).orElseThrow(() -> new NotFoundResponse("Course not found"));
            ctx.render("courses/course.jte", model("page", new CoursePage(course)));
        });
        app.post(NamedRoutes.coursesPath(), ctx -> {
            Course course = new Course();
            try{
                course.setName(ctx.formParamAsClass("name", String.class)
                                            .check(value -> !CoursesRepository.existsByName(value),
                                                   "Курс с таким именем уже существует")
                                             .check(value -> value.length() < 40, "Название курса слишком длинное")
                                             .get());
                course.setDescription(ctx.formParamAsClass("description", String.class)
                                                    .check(value -> value.length() < 300,
                                                           "Описание должно быть меньше 300 символов")
                                                    .get());
                course.setContent(ctx.formParam("content"));
                CoursesRepository.save(course);
                ctx.redirect(NamedRoutes.coursesPath());
            }catch (ValidationException e){
                var page = new BuildCoursePage(course, e.getErrors());
                ctx.render("courses/courseBuild.jte", model("page", page));
            }
        });
        app.start(7070);
    }
}
