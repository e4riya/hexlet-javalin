package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        app.get("/hello",ctx -> {
            String name = ctx.queryParamAsClass("name",String.class).getOrDefault("World");
            ctx.result("Hello, " + name + "!");
        });
        app.start(7070);
    }
}
