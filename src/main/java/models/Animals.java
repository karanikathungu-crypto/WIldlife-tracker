package models;
import java.util.Objects;
import java.util.ArrayList;

public class Animals implements Spotted_animal{
    private int id;
    private String name;
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRangerName() {
        return rangerName;
    }

    public void setRangerName(String rangerName) {
        this.rangerName = rangerName;
    }

    private String rangerName;
    private static ArrayList<Animals> mInstances = new ArrayList<>();

    public Animals( String name, String location, String rangerName){
        this.name = name;
        this.location = location;
        this.rangerName = rangerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animals)) return false;
        Animals animals = (Animals) o;
        return getId() == animals.getId() &&
                getName() == animals.getName() &&
                Objects.equals(getName(), animals.getName());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getId(), getName());
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public static ArrayList<Animals> getAllInstances() {
        return mInstances;
    }

    @Override
    public void seenAnimal()
    {
        System.out.println("The animal spotted is:"+name);
    }
}
