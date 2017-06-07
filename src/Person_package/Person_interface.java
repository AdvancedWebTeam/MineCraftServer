package Person_package;

import java.util.ArrayList;

public interface Person_interface {
       ArrayList<Person> initialization();
       void addPerson(ArrayList<Person> a, String id, double x, double y, double z, double movementX);
       String addPerson(ArrayList<Person> a, double x, double y, double z, double movementX);
       void removePerson(ArrayList<Person> a, String id);
       void changePerson(ArrayList<Person> a, String id, double x, double y, double z, double movementX);
       void print(ArrayList<Person> a);
       ArrayList<Person> readio();
       void writeio(ArrayList<Person> a);
}
