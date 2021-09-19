package models;

public class Endangered_animals {
    private int id;
    private String name;
    private String health;
    private int age;

    public Endangered_animals(int id, String name, String health, int age){
        this.id = id;
        this.name = name;
        this.health = health;
        this.age = age;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getHealth(){
        return health;
    }
    public int getAge(){
        return age;
    }
}
