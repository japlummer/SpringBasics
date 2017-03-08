package com.theironyard.novauc;

import spark.Spark;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    static User user;


    static HashMap<String, User> users = new HashMap<>();
    static ArrayList<Message> messages = new ArrayList<>();


    public static void main(String[] args) {
        // write your code here


        Spark.init();

        Spark.get(
                "/",
                ((request, response) -> {
                    String text = request.queryParams("messageText");
                    HashMap m = new HashMap();
                    ArrayList<Message> post = new ArrayList<>();
                    if (user == null) {
                        return new ModelAndView(messages, "index.html");
                    } else {
                        m.put("name", user.name);
                        m.put("post", messages);
                        return new ModelAndView(m, "message.html");
                    }
                }),
                new MustacheTemplateEngine()
        );

        Spark.post(
                "/login",
                ((request, response) -> {
                    String name = request.queryParams("loginName");
                    user = new User(name);
                    response.redirect("/");
                    return "";

                })
        );



        Spark.post(
                "/create-user",
                ((request, response) -> {
                    String name = request.queryParams("loginName");
                    user = new User(name);
                    response.redirect("/");
                    return "";
                })
        );

        Spark.post(
                "/create-message",
                ((request, response) -> {
                    String text = request.queryParams("messageText");
                    Message message = new Message(text);
                    messages.add(message);

                    response.redirect("/");
                    return "";


                })

        );
    }

    }
















