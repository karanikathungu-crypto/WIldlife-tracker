package dao;
import models.*;
import org.sql2o.*;
import java.util.List;

public class Sql2oAnimalsDao implements AnimalsDao {
    private final Sql2o sql2o;

    public Sql2oAnimalsDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }
}
