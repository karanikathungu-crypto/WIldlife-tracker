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
    @Override
    public void update(int id, String name){
        String sql = "UPDATE animals SET name = :name WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id", name)//check later for possible error
                    .addParameter("name", name)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
//    @Override
//    public void deleteById(int id) {
//        String sql = "DELETE from animals WHERE id=:id";
//        try (Connection con = sql2o.open()) {
//            con.createQuery(sql)
//                    .addParameter("id", id)
//                    .executeUpdate();
//        } catch (Sql2oException e){
//            System.out.println(e);
//        }
//        }
    }
    @Override
    public void clearAllAnimals() {
        String sql = "DELETE from animals";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException e){
            System.out.println(e);
        }
    }
}
