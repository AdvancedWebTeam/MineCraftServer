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
            Messege m = new Messege(new Action(p));
            try {
                myWebSocket.sendMessage(messegeToJSONString(m));
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
        try(Reader reader = new StringReader(message)){
            Gson gson = new GsonBuilder().create();
            Messege m = gson.fromJson(reader, Messege.class);
            System.out.println(m.Action.x+" "+m.Action.y+" "+m.Action.z);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String messegeToJSONString(Messege m) {
        return null;
    }

}
