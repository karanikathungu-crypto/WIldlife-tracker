package models;
import java.util.Objects;
import java.util.ArrayList;

public class Animals implements Spotted_animal{
    private int id;
    private String name;

    public Animals(int id, String name){
        this.id = id;
        this.name = name;
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
    @Override
    public void seenAnimal()
    {
        System.out.println("The animal spotted is:"+name);
    }
}
