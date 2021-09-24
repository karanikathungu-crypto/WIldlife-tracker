package dao;
import models.*;
import java.util.List;

public interface AnimalsDao {

    void add(Animals animals);//CreateReadUpdateDelete

    Animals findById(int id);

    List<Animals>getAll();

  void update(int id, String name);

//  void deleteById(int id);
  void clearAllAnimals();
}
