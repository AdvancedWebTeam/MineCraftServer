package Person_package;


import java.util.Vector;

public interface Person_interface {
       Vector<Person> initialization();
       void addPerson(Vector<Person> a, String id, double x, double y, double z, double movementX);
       String addPerson(Vector<Person> a, double x, double y, double z, double movementX);
       void removePerson(Vector<Person> a, String id);
       void changePerson(Vector<Person> a, String id, double x, double y, double z, double movementX);
       void print(Vector<Person> a);
       Vector<Person> readio();
       void writeio(Vector<Person> a);
}
