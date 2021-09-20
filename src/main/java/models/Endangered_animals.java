package models;
public class Endangered_animals implements Spotted_animal{
    private int id;
    private String name;
    private String health;
    private int age;

    private static String healthy;
    private static String ill;
    private static String okay;
    private static String newborn;
    private static String young;
    private static String adult;

    public static final String HEALTH = healthy;
    public static final String ILL = ill;
    public static final String OKAY = okay;
    public static final String NEWBORN = newborn;
    public static final String YOUNG = young;
    public static final String ADULT = adult;



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
    @Override
    public void seenAnimal(){
        System.out.println("The animal spotted is:"+name);
    }
}
