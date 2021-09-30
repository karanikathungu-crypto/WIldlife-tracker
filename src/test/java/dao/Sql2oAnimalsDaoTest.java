package dao;
import models.Endangered_animals;
import models.Animals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.*;
import static org.junit.Assert.*;

public class Sql2oAnimalsDaoTest
{
    private Sql2oAnimalsDao animalsDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "kenneth","1234");
        animalsDao = new Sql2oAnimalsDao();
        conn = sql2o.open();
    }
    @After
    public void tearDown() throws Exception{
        conn.close();
    }

    @Test
    public void add_addingAnimalSetsId() throws Exception {
        Animals animals = new Animals("lion","zone A", "Mark");
        int firstAnimalId = animals.getId();
        animalsDao.add(animals);
        assertNotEquals(firstAnimalId, animals.getId());
    }

    @Test
    public void existingAnimalsCanBeFoundById() throws Exception {
        Animals animals = new Animals("crocodile", "zone B", "John");
        animalsDao.add(animals);
        Animals foundAnimal = animalsDao.findById(animals.getId());
        assertEquals(animals, foundAnimal);
    }

//    @Test
//    public void () {
//    }
}