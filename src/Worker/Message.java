package Worker;
import Point_package.Action;
import Person_package.Person;
import Person_package.PersonLeave;
/*
 * Created by lyz on 17-6-1.
 */
public class Message {
    Action Action;
    Person Person;
    PersonLeave PersonLeave;
    Message(Action action) {
        Action = action;
    }

    public Message(Person person) {
        Person = person;
    }

    public Message(PersonLeave personLeave) {
        PersonLeave = personLeave;
    }
}
