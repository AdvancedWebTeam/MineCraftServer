package Worker;

import Point_package.Point;

/**
 * Created by lyz on 17-6-1.
 */
public class Action {
    int action; //0: add, 1: remove
    double x;
    double y;
    double z;
    int material;
    Action(Point p) {
        action = 0;
        this.x = p.getx();
        this.y = p.gety();
        this.z = p.getz();
    }
    Action(Point p, int action) {
        this.action = action;
        this.x = p.getx();
        this.y = p.gety();
        this.z = p.getz();
    }
    boolean isAddition() {
        return (action==0);
    }
}
