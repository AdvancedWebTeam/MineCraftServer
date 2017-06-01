package Worker;

import Point_package.Point;
import Point_package.Point_operationimpl;

import MyWebSocket.MyWebSocket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by lyz on 17-6-1.
 */
public class Worker {
    private static ArrayList<Point> point_list;
    private static Point_operationimpl xx = new Point_operationimpl();
    public Worker() {
        try {
            point_list = xx.readio();
        } catch (FileNotFoundException e) {
            point_list = xx.initialization();
        }
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
    }

    public void close() {
        try {
            xx.writeio(point_list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doWork(String message) {
        Message m = JSONStringToMessage(message);
        if (m.Action!=null)
        {
            if (m.Action.action==0)
                xx.addpoint(point_list, m.Action.x, m.Action.y, m.Action.z, m.Action.material);
            else if (m.Action.action==1)
                xx.removepoint(point_list, m.Action.x, m.Action.y, m.Action.z, m.Action.material);
        }
    }
    private Message JSONStringToMessage(String message) {
        Gson gson = new GsonBuilder().create();
        Message m = gson.fromJson(message, Message.class);
        System.out.println(m.Action.x+" "+m.Action.y+" "+m.Action.z);
        return m;

    }
    private String messageToJSONString(Message m) {

        Gson gson = new GsonBuilder().create();
        return gson.toJson(m);

    }

}
