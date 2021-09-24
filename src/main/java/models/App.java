package models;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dao.Sql2oAnimalsDao;
import models.Animals;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Sql2oAnimalsDao sql2oAnimalsDao = new Sql2oAnimalsDao();

        staticFileLocation("/public");

        get("/",(request, response)->{
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        },new HandlebarsTemplateEngine());

        get("/animal_form",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "animal_form.hbs");
        },new HandlebarsTemplateEngine());
        post("/Success/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            String location = request.queryParams("location");
            String rangerName = request.queryParams("rangerName");
            model.put("name", name);
            model.put("location", location);
            model.put("rangerName", rangerName);
            Animals seenAnimal = new Animals(name, location, rangerName);
            sql2oAnimalsDao.add(seenAnimal);
            return new ModelAndView(model, "Success.hbs");
        }, new HandlebarsTemplateEngine());
//        get("/Success", (request, response)->{
//            Map<String, Object> model = new HashMap<>();
//            ArrayList<Animals> animal = Animals.getAllInstances();
//            model.put("animal", animal);
//            return new ModelAndView(model, "Success.hbs");
//        }, new HandlebarsTemplateEngine());




    }
}
