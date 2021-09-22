package models;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import models.Animals;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/",(request, response)->{
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        },new HandlebarsTemplateEngine());

        get("/animal_form",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "animal_form.hbs");
        },new HandlebarsTemplateEngine());
        post("/Success", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("animal_Name");
            int id = Integer.parseInt(request.queryParams("animal_Id"));//changed it to parse int because of error
            Animals seenAnimal = new Animals(id, name);
            request.session().attribute("item", seenAnimal );
            model.put("item", request.session().attribute("item"));
            model.put("seenAnimal", seenAnimal);
            return new ModelAndView(model, "Success.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
