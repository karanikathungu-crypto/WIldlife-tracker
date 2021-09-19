package dao;
import models.*;
import org.sql2o.*;
import java.util.List;

public class Sql2oAnimalsDao implements AnimalsDao {
    private final Sql2o sql2o;

    public Sql2oAnimalsDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Animals animals){
        String sql = "INSERT INTO animals (id, name) VALUES(:id, :name)";
        try(Connection conn = sql2o.open()){
            int id = (int) conn.createQuery(sql, true)
                    .bind(animals)
                    .executeUpdate()
                    .getKey();
            animals.setId(id);
        }   catch(Sql2oException e){
            System.out.println(e);
        }
    }
    @Override
    public List<Animals>getAll(){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM animals")
                    .executeAndFetch(Animals.class);
        }
    }
    @Override
    public Animals findById(int id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM animals WHERE id = :id")
                    .addParameter("id",id)
                    .executeAndFetchFirst(Animals.class);
        }
    }
}
