package dao;
import models.Endangered_animals;
import models.Animals;
import org.junit.Before;
import org.sql2o.*;
import static org.junit.Assert.*;

public class Sql2oAnimalsDaoTest
{
    private Sql2oAnimalsDao animalsDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "","");
        animalsDao = new Sql2oAnimalsDao(sql2o);
        conn = sql2o.open();
    }

}