package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AnimalsTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getLocationGivesCorrectLocation() {
        Animals testAnimals = setUpAnimal();
        assertEquals("Zone A", testAnimals.getLocation());
    }

    @Test
    public void getNameGivesCorrectName() {
        Animals testAnimals = setUpAnimal();
        assertEquals("Lion", testAnimals.getName());
    }

    @Test
    public void getRangerNameGivesCorrectRangerName() {
        Animals testAnimals = setUpAnimal();
        assertEquals("Mary", testAnimals.getRangerName());

    }


    public Animals setUpAnimal() {
        return new Animals("Lion", "Zone A", "Mary");
    }
}

