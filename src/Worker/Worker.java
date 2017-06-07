package Worker;

import Person_package.Person;
import Person_package.PersonLeave;
import Person_package.Person_operationimpl;
import Point_package.Point;
import Point_package.Point_operationimpl;

import MyWebSocket.MyWebSocket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import Point_package.Action;

import javax.websocket.Session;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by lyz on 17-6-1.
 */
public class Worker {
    private static ArrayList<Point> point_list;
    private static ArrayList<Person> person_list;
    private static Point_operationimpl xx = new Point_operationimpl();
    private static Person_operationimpl yy = new Person_operationimpl();
    private static HashMap<Session, String> personMap = new HashMap<>();
    public Worker() {
        point_list = xx.readio();
        if (point_list==null) point_list = xx.initialization();
        person_list = yy.readio();
        if (person_list==null) person_list = yy.initialization();
    }
    public void doInit(MyWebSocket myWebSocket) {
        for (Point p: point_list){
            Message m = new Message(new Action(p));
            try {
                myWebSocket.sendMessage(messageToJSONString(m));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (Person pp: person_list) {
            Message m = new Message(pp);
            try {
                myWebSocket.sendMessage(messageToJSONString(m));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void close() {

        xx.writeio(point_list);

    }

    public void doWork(String message, Session s) {
        Message m = JSONStringToMessage(message);
        if (m.Action!=null)
        {
            if (m.Action.getAction() ==0)
                xx.addPoint(point_list, m.Action.getX(), m.Action.getY(), m.Action.getZ(), m.Action.getMaterial());
            else if (m.Action.getAction() ==1)
                xx.removePoint(point_list, m.Action.getX(), m.Action.getY(), m.Action.getZ(), m.Action.getMaterial());
        }
        if (m.Person!=null){
            yy.changePerson(person_list, m.Person.getId(),m.Person.getX(),m.Person.getY(),m.Person.getZ(),m.Person.getRotation());
            if (!personMap.containsKey(s)) personMap.put(s, m.Person.getId());
        }
        
    }
    private Message JSONStringToMessage(String message) {
        Gson gson = new GsonBuilder().create();
        Message m = gson.fromJson(message, Message.class);
//        System.out.println(m.Action.x+" "+m.Action.y+" "+m.Action.z);
        return m;

    }

    private String messageToJSONString(Message m) {
        Gson gson = new GsonBuilder().create();
        String s = gson.toJson(m);
        return s;
    }

    public String doLeave(Session s) {

        String id = personMap.get(s);
        if (id!=null) {
            personMap.remove(s);
            yy.removePerson(person_list,id);
            return messageToJSONString(new Message(new PersonLeave(id)));
        }
        return null;
    }
}
